 package com.cpt.controller;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.cpt.req.MessageReceiveReq;
import com.cpt.vo.MessageJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.Result;
import com.cpt.model.Message;
import com.cpt.req.MessageReq;
import com.cpt.service.MessageService;
import com.cpt.service.UserService;
 
@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired 
	private UserService userService;
	@Autowired  
	private MessageService messageService;
	
    /**
     * 分页消息
     *
     * @param modelMap
     * @param messageReq
     * @return
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(ModelAndView modelMap,MessageReq messageReq ) {
    	modelMap.addObject("result", messageService.queryReceiveMessage(messageReq));
        modelMap.setViewName("message/view-notification");
        modelMap.addObject("user",userService.getUser());
        modelMap.addObject("cur_module","account");
        modelMap.addObject("cur_menu","view_message");
		return modelMap;
    }
    /**
     * 分页消息
     *
     * @param modelMap
     * @param messageReq
     * @return
     */
    @RequestMapping(value = "/viewSend")
    public ModelAndView viewSend(ModelAndView modelMap,MessageReq messageReq ) {
        modelMap.addObject("result", messageService.querySendMessage(messageReq));
        modelMap.setViewName("message/view-send-notification");
        modelMap.addObject("user",userService.getUser());
        modelMap.addObject("cur_module","account");
        modelMap.addObject("cur_menu","view_send_message");
        return modelMap;
    }
    /**
     * 发送消息
     *
     * @param modelMap
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/send")
    public ModelAndView send(ModelAndView modelMap,PageParam pageParam ) {
    	modelMap.addObject("user",userService.getUser());
        modelMap.setViewName("message/send-notification");
        modelMap.addObject("cur_module","account");
        modelMap.addObject("cur_menu","send_message");
		return modelMap;
    }
    /**
     * 增加或者修改
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(Message message) {
    	return messageService.addOrEdit(message);
    }
 
	/**
     * 阅读
     *
     * @param messageReceiveReq
     * @return
     */
    @RequestMapping(value = "/read", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> read(MessageReceiveReq messageReceiveReq) {
    	return messageService.read(messageReceiveReq);
    }
    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> delete(Long id) {
    	return messageService.delete(id);
    }
    /**
     * 查询
     *
     * @param id
     * @return
     */
   @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public Result<MessageJsonVo> view(Long id) {
    	return messageService.getReceiveList(id);
    }
	
}
