package com.cpt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Event;
import com.cpt.req.EventReq;
import com.cpt.service.CustomerService;
import com.cpt.service.EventService;
import com.cpt.vo.EventVo;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private static final Logger log =  LoggerFactory.getLogger(EventController.class);
	
	@Autowired 
	private EventService eventService;
	
	@Autowired 
	private CustomerService customerService;
 
	  /**
     * 工程管理列表
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav) {
        mav.setViewName("event/event_list");
        return mav;
    }
  
    
	 /**
     * 分页数据
     *
     * @param pageParam
     * @param projectVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public PageResult<EventVo> pageList(PageParam pageParam, EventReq eventReq) {
        return eventService.pageList(pageParam, eventReq);
    }
    
    /**
     * 工程详情
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView detail(ModelAndView mav, Integer id) {
    	EventVo eventVo = eventService.detail(id);
        mav.addObject("eventVo", eventVo);
        mav.setViewName("event/event_detail");
        return mav;
    }
    /**
     * 工程创建页面
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("event/event_detail");
        return mav;
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
    public Result<Integer> addOrEdit(EventReq eventReq) {
    	return eventService.addOrEdit(eventReq);
    }
  
    /**
     * 派遣
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/sendHandler", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> sendHandler(EventReq eventReq) {
    	return eventService.sendHandler(eventReq);
    }
}
