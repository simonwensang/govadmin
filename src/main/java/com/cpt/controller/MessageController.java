 package com.cpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
 
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired  
	private MessageService messageService;
	
	 
    /**
     * 分页消息
     *
     * @param UserQuery
     * @param user
     * @return
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(ModelAndView modelMap,MessageReq messageReq ) {
    	modelMap.addObject("result", messageService.pageList(messageReq));
        modelMap.setViewName("message/view-notification");
		return modelMap;
    }
    
    /**
     * 发送消息
     *
     * @param UserQuery
     * @param user
     * @return
     */
    @RequestMapping(value = "/send")
    public ModelAndView send(ModelAndView modelMap,PageParam pageParam ) {
        modelMap.setViewName("message/send-notification");
		return modelMap;
    }
    /**
     * 增加或者修改
     *
     * @param mav
     * @param id
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
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/read", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> read(Long id) {
    	return messageService.read(id);
    }
    /**
     * 删除
     *
     * @param mav
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
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Result<Message> get(Long id) {
    	return messageService.get(id);
    }
	
}
