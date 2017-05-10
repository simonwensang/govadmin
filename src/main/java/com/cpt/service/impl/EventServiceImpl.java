package com.cpt.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.AuthorityStatus;
import com.cpt.common.constant.EventStatus;
import com.cpt.common.constant.HandleType;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.util.CodeFactory;
import com.cpt.convertor.EventConvertor;
import com.cpt.mapper.EventHandleLogMapper;
import com.cpt.mapper.EventMapper;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.WorkFlowMapper;
import com.cpt.mapper.ext.EventExtMapper;
import com.cpt.mapper.ext.WorkFlowExtMapper;
import com.cpt.model.Event;
import com.cpt.model.EventHandleLog;
import com.cpt.model.EventHandleLogExample;
import com.cpt.model.User;
import com.cpt.model.WorkFlow;
import com.cpt.req.EventReq;
import com.cpt.service.EventService;
import com.cpt.service.UserCommonService;
import com.cpt.service.UserService;
import com.cpt.vo.EventVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class EventServiceImpl implements EventService {
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventExtMapper eventExtMapper;
	@Resource
	private UserCommonService userCommonService;
	@Resource
	private UserService userService;
	@Resource
	private UserMapper userMapper;
	@Resource
	private WorkFlowMapper workFlowMapper;
	@Resource
	private WorkFlowExtMapper workFlowExtMapper;
	@Resource
	private EventHandleLogMapper eventHandleLogMapper;
	
	@Value("${image.url}")
	private String imageurl ; 
	
	@Value("${server.imagepath}")
	private String imagepath ; 
	
	@Value("${server.imagepath.attachment}")
	public  String attachment ; 
	@Override
	public PageResult<EventVo> pageList(PageParam pageParam, EventReq eventReq) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<Event> events = eventExtMapper.pageList(eventReq);
        //构造分页结果
        PageResult<EventVo> pageResult = PageResult.newPageResult(EventConvertor.toEventVoList( events), ((Page<Event>)events).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	
	}

	@Override
	public EventVo detail(Integer id) {
		Event event = this.get(id);
		if( null == event){
			return new EventVo();
		}
		List<EventHandleLog> eventHandleLogList = this.selectEventHandleLogByEventId(id);
		event.setEventHandleLogList(eventHandleLogList);
		return EventConvertor.toEventVo(event);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(EventReq eventReq) {
		if(null==eventReq.getAuditorId()){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
		}
		if(null!=eventReq.getCcUserId() && eventReq.getCcUserId().equals(eventReq.getAuditorId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_USER_REPEAT);
		}
		Event event = EventConvertor.reqToEvent(eventReq);
		User user = userCommonService.getUser();
		User auditor = userService.get(eventReq.getAuditorId().longValue());
		event.setAuditor(auditor.getName());
		if(eventReq.getId()==null){
			//保存图片
			if(null!=eventReq.getMultFile()){
				MultipartFile image = eventReq.getMultFile();
				String path = this.imagepath+this.attachment;
				String imageName= image.getOriginalFilename();
				String realname = path+"/"+imageName;
				try {
					FileUtils.copyInputStreamToFile(image.getInputStream(), new File(realname));
				} catch (IOException e) {
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.FILE_SAVE_ERROR);
				}
				event.setAttachment(realname);
			}
			event.setEventNo(CodeFactory.getCode());
			event.setEventStatus(EventStatus.AUDIT.getKey());
			event.setCommitUser(user.getName());
			event.setCommitUserId(user.getId().intValue());
			event.setCommitTime(new Date());
			event.setUpdateUser(user.getName());
			event.setUpdateUserId(user.getId().intValue());
			this.insert(event);
			this.insertEventHandleLog(HandleType.COMMIT, user.getName(), user.getId().intValue(), event.getId());
			this.insertWorkFlow(event.getId().longValue(), user.getId(), user.getId(), AuthorityStatus.COMMIT_USER,EventStatus.INIT);
			if(null!=event.getCcUserId()){
				this.insertWorkFlow(event.getId().longValue(), user.getId(),event.getCcUserId().longValue() , AuthorityStatus.CC_USER,EventStatus.INIT);
			}
			return Result.newResult(this.insertWorkFlow(event.getId().longValue(), user.getId(), eventReq.getAuditorId().longValue(), AuthorityStatus.AUDITOR,EventStatus.AUDIT));
		}else{
			//权限 只能修改自己有项目
			//TODO...
			event.setUpdateUser(user.getName());
			event.setUpdateUserId(user.getId().intValue());
			return Result.newResult(this.update(event));
		}
	}
	

	/* (non-Javadoc)
	 * @see 派遣
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> sendHandler(EventReq eventReq) {
		if(null==eventReq.getId()){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
		}
		Event event =  this.get(eventReq.getId());
		if(null==event){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		User user = userCommonService.getUser();
		if(!user.getId().equals(event.getAuditorId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		Event param = new Event();
		param.setId(eventReq.getId());
		param.setRespDepartment(eventReq.getRespDepartment());
		param.setRespDepartmentId(eventReq.getRespDepartmentId());
		param.setExpiryDate(eventReq.getExpiryDate());
		param.setRequest(eventReq.getRequest());
		param.setAuditRemark(eventReq.getAuditRemark());
		param.setAuditorTime(new Date());
		param.setEventStatus(EventStatus.HANDLE.getKey());
		Result.newResult(this.update(param));
		return Result.newResult(this.insertEventHandleLog(HandleType.AUDITE, user.getName(), user.getId().intValue(), event.getId()));
	}
	
	@Override
	public Result<Integer> handle(EventReq eventReq) {
		if(null==eventReq.getId()){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
		}
		User user = userCommonService.getUser();
		/*Event event =  this.get(eventReq.getId());
		if(null==event){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		
		if(!user.getId().equals(event.getAuditorId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}*/
		Event param = new Event();
		param.setId(eventReq.getId());
		param.setHandler(user.getName());
		param.setHandlerId(user.getId().intValue());
		param.setHandleTime(eventReq.getHandleTime());
		param.setHandleResult(eventReq.getHandleResult());
		param.setHandleRemark(eventReq.getHandleRemark());
		param.setEventStatus(EventStatus.CLOSE.getKey());
		Result.newResult(this.update(param));
		return Result.newResult(this.insertEventHandleLog(HandleType.HANDLE, user.getName(), user.getId().intValue(), eventReq.getId()));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> higherUp(EventReq eventReq) {

		if(null==eventReq.getAuditorId()){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
		}
		Event event =  this.get(eventReq.getId());
		if(null==event){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		User user = userCommonService.getUser();
		if(!user.getId().equals(event.getAuditorId())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.NO_AUTHOR);
		}
		Event param = new Event();
		param.setId(eventReq.getId());
		param.setAuditor(eventReq.getAuditor());
		param.setAuditorId(eventReq.getAuditorId());
		this.update(param);
		this.insertEventHandleLog(HandleType.AUDITE, user.getName(), user.getId().intValue(), event.getId());
		
		return Result.newResult(this.insertWorkFlow(event.getId().longValue(), user.getId(), eventReq.getAuditorId().longValue(), AuthorityStatus.AUDITOR,EventStatus.AUDIT));
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer insertWorkFlow(Long refId,Long appointUser,Long creator,AuthorityStatus authorityStatus,EventStatus eventStatus){
		WorkFlow workFlow = new WorkFlow();
		workFlow.setAuthority(authorityStatus.getKey());
		workFlow.setCreator(creator);
		workFlow.setRefId(refId);
		workFlow.setUserId(appointUser);
		workFlow.setStatus(eventStatus.getKey());
		return workFlowMapper.insertSelective(workFlow);
	}
	 
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer insertEventHandleLog(HandleType handleType,String handler,Integer handlerId,Integer eventId){
		EventHandleLog eventHandleLog = new EventHandleLog();
		eventHandleLog.setHandleType(handleType.getKey());
		eventHandleLog.setHandler(handler);
		eventHandleLog.setHandlerId(handlerId);
		eventHandleLog.setEventId(eventId);
		return eventHandleLogMapper.insertSelective(eventHandleLog);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Event get(Integer id) {
		return eventMapper.selectByPrimaryKey(id);
	}
	
	public List<EventHandleLog> selectEventHandleLogByEventId(Integer eventId) {
		EventHandleLogExample example = new EventHandleLogExample();
		EventHandleLogExample.Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventId);
		return eventHandleLogMapper.selectByExample(example);
	}
	 
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	private int insert(Event event){
		return eventExtMapper.insertSelective(event);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	private int update(Event event){
		return eventMapper.updateByPrimaryKeySelective(event);
	}

	
}
