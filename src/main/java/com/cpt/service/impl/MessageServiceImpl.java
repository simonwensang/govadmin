package com.cpt.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.cpt.common.constant.MessageStatus;
import com.cpt.mapper.MessageReceiveMapper;
import com.cpt.mapper.ext.MessageReceiveExtMapper;
import com.cpt.model.MessageReceive;
import com.cpt.model.MessageReceiveExample;
import com.cpt.req.MessageReceiveReq;
import com.cpt.vo.MessageJsonVo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.constant.ReadType;
import com.cpt.common.constant.RoleCode;
import com.cpt.mapper.MessageMapper;
import com.cpt.mapper.ext.MessageExtMapper;
import com.cpt.model.Message;
import com.cpt.model.User;
import com.cpt.req.MessageReq;
import com.cpt.service.MessageService;
import com.cpt.service.UserCommonService;
import com.cpt.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageExtMapper messageExtMapper;
	
	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private MessageReceiveMapper messageReceiveMapper;

	@Autowired
	private MessageReceiveExtMapper messageReceiveExtMapper;
	
	@Resource
	private UserCommonService userCommonService;
	@Resource
	private  UserService userService;
	
	@Value("${oss.web.url}")
	public String ossWebUrl;
	
	@Override
	public Result<MessageJsonVo> getReceiveList(Long id) {
		if(id==null){
			return new Result<MessageJsonVo>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		Message message  = messageMapper.selectByPrimaryKey(id);
		if(message==null){
			return new Result<MessageJsonVo>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		MessageReceiveExample example =  new MessageReceiveExample();
		example.createCriteria().andMessageIdEqualTo(id);
		List<MessageReceive> messageReceiveList = messageReceiveMapper.selectByExample(example);
		MessageJsonVo messageJsonVo = new MessageJsonVo();
		messageJsonVo.setContent(message.getContent());
		MessageJsonVo.MessageNode messageNode = null;
		List<MessageJsonVo.MessageNode> msgs =Lists.newArrayList();
		for ( MessageReceive messageReceive : messageReceiveList ) {
			messageNode = new MessageJsonVo.MessageNode();
			messageNode.setName(messageReceive.getReceiver());
			messageNode.setStatus(MessageStatus.getValueByKey(messageReceive.getStatus()));
			msgs.add(messageNode);
		}

		messageJsonVo.setMsgs(msgs);
		return Result.newResult(messageJsonVo);
	}

	@Override
	public Result<Message> get(Long id) {
		if(id==null){
			return new Result<Message>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		return Result.newResult(messageExtMapper.get(id));
	}

	@Override
	public PageResult<Message> querySendMessage(MessageReq pageParam) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getRows());
        //当前页列表
        pageParam.setUserId(userCommonService.getUserId());
        List<Message> messages = messageExtMapper.pageList(pageParam);
        for ( Message message : messages) {
			if(StringUtils.isNotBlank(message.getAttachment())) {
				message.setAttachmentFile(StringUtils.substringAfterLast(message.getAttachment(), "/"));
				message.setAttachment(ossWebUrl + message.getAttachment());
			}
		}
        //构造分页结果
        PageResult<Message> pageResult = PageResult.newPageResult(messages, ((Page<Message>)messages).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public PageResult<Message> queryReceiveMessage(MessageReq pageParam) {
		//分页
		PageHelper.startPage(pageParam.getPage(), pageParam.getRows());
		//当前页列表
		pageParam.setReplyId(userCommonService.getUserId());
		List<Message> messages = messageExtMapper.receiveList(pageParam);
		for ( Message message : messages) {
			if(StringUtils.isNotBlank(message.getAttachment())){
				message.setAttachmentFile(StringUtils.substringAfterLast(message.getAttachment(), "/"));
				message.setAttachment(ossWebUrl+message.getAttachment());
			}
		}
		//构造分页结果
		PageResult<Message> pageResult = PageResult.newPageResult(messages, ((Page<Message>)messages).getTotal(), pageParam.getPage(), pageParam.getRows());
		return pageResult;
	}
	@Override
	public Result<Integer> addOrEdit(Message message) {
		if(StringUtils.isBlank( message.getContent())
				||StringUtils.isBlank(message.getReply())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		User user = userService.getUser();
		//只有 乡镇人员可以发送消息
    	if(!RoleCode.TOWN.getKey().equals(user.getRole().getRoleCode())
		    &&!RoleCode.ADMIN.getKey().equals(user.getRole().getRoleCode())
				&&!RoleCode.SUPERUSER.getKey().equals(user.getRole().getRoleCode())){
    		return new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc());
    	}
		message.setUser(user.getName());
		message.setUserId(user.getId());
		List<Long> ids = Lists.newArrayList();
		String[] idstr = message.getReply().split(",");
		for (String id: idstr) {
			ids.add(Long.parseLong(id));
		}
		if(ids.isEmpty()){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		message.setReplyIdList(ids);
		if(message.getId()==null){
			StringBuilder reply = new StringBuilder();
			List<User> users = userService.getUserList(message.getReplyIdList());
			Map<Long,String> map =new HashMap<Long,String>();
			for (int i =0 ; i< users.size();i++) {
				User model = users.get(i);
				map.put(model.getId(),model.getName());
			}
			if(users.size()>2){
				reply.append(users.get(0).getName()).append(",")
				.append(users.get(1).getName()).append("..等");
			}
			message.setReply(reply.toString());
			this.insert(message);

			List<MessageReceive> messageReceiveList = Lists.newArrayList();
			MessageReceive messageReceive = null;
			for (Long replyId : message.getReplyIdList()){
				messageReceive = new  MessageReceive();
				messageReceive.setMessageId(message.getId());
				messageReceive.setReceiveId(replyId);
				messageReceive.setReceiver(map.get(replyId));
				messageReceiveList.add(messageReceive);
			}

			return Result.newResult(messageReceiveExtMapper.insertList(messageReceiveList));
		}else{
			return Result.newResult(this.update(message));
		}
	}

	@Override
	public Result<Integer> read(MessageReceiveReq messageReceiveReq) {
		MessageReceive messageReceive = new MessageReceive();
		messageReceive.setId(messageReceiveReq.getId());
		messageReceive.setStatus(messageReceiveReq.getStatus());
		return Result.newResult(this.updateReceive(messageReceive));
	}
	
	@Override
	public Result<Integer> delete(Long id) {
		return  Result.newResult(messageMapper.deleteByPrimaryKey(id));
	}

	private int insert(Message message){
		return messageExtMapper.insertSelective(message);
	}

	private int update(Message message){
		return messageMapper.updateByPrimaryKeySelective(message);
	}

	private int updateReceive(MessageReceive messageReceive){
		return messageReceiveMapper.updateByPrimaryKeySelective(messageReceive);
	}
}
