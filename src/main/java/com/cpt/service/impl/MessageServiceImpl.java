package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

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
	
	@Resource
	private UserCommonService userCommonService;
	@Resource
	private  UserService userService;
	
	@Value("${oss.web.url}")
	public String ossWebUrl;
	
	@Override
	public Result<Message> get(Long id) {
		if(id==null){
			return new Result<Message>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		return Result.newResult(messageExtMapper.get(id));
	}

	@Override
	public PageResult<Message> pageList(MessageReq pageParam) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getRows());
        //当前页列表
        pageParam.setReplyId(userCommonService.getUserId());
        List<Message> messages = messageExtMapper.pageList(pageParam);
        for ( Message message : messages) {
        	message.setAttachmentFile(StringUtils.substringAfterLast(message.getAttachment(), "/"));
        	message.setAttachment(ossWebUrl+message.getAttachment());
		}
        //构造分页结果
        PageResult<Message> pageResult = PageResult.newPageResult(messages, ((Page<Message>)messages).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public Result<Integer> addOrEdit(Message message) {
		if(StringUtils.isBlank( message.getContent())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		User user = userService.getUser();
		//只有 乡镇人员可以发送消息
    	if(!RoleCode.TOWN.getKey().equals(user.getRole().getRoleCode())){
    		return new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc());
    	}
		message.setUser(user.getName());
		message.setUserId(user.getId());
		if(message.getId()==null){
			return Result.newResult(this.insert(message));
		}else{
			return Result.newResult(this.update(message));
		}
	}

	@Override
	public Result<Integer> read(Long id) {
		Message message = new Message();
		message.setId(id);
		message.setIsRead(ReadType.READ.getKey());
		return Result.newResult(this.update(message));
	}
	
	@Override
	public Result<Integer> delete(Long id) {
		return  Result.newResult(messageMapper.deleteByPrimaryKey(id));
	}

	private int insert(Message message){
		return messageMapper.insertSelective(message);
	}

	private int update(Message message){
		return messageMapper.updateByPrimaryKeySelective(message);
	}
}
