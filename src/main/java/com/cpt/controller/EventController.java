package com.cpt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.Constants;
import com.cpt.common.constant.EventType;
import com.cpt.model.Organization;
import com.cpt.req.EventReq;
import com.cpt.service.CustomerService;
import com.cpt.service.EventService;
import com.cpt.service.OrganizationService;
import com.cpt.vo.EnumBean;
import com.cpt.vo.EventVo;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private static final Logger log =  LoggerFactory.getLogger(EventController.class);
	
	@Autowired 
	private EventService eventService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired 
	private  OrganizationService organizationService;
	 
	 /**
     * 事件分页查询
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/allReport", method = RequestMethod.GET)
    public ModelAndView allReport(ModelAndView mav,EventReq eventReq) {
    	
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	
    	mav.addObject("result", result);
        mav.setViewName("event/allReport");
        return mav;
    }
  
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
     * 详情
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
     * 详情
     *
     * @param mav
     * @param eventType
     * @return
     */
    @RequestMapping(value = "/submission", method = RequestMethod.GET)
    public ModelAndView submission(ModelAndView mav, Byte eventType) {
    	List<Organization> organizationList = organizationService.selectByLevel(Constants.LEVEL_2);
    	eventType = null==eventType?1:eventType;
    	mav.addObject("eventType", new EnumBean(eventType,EventType.getValueByKey(eventType)));
    	mav.addObject("organizationList", organizationList);
        mav.setViewName("event/submission");
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
    public String addOrEdit(ModelMap map , EventReq eventReq) {
    	 Result<Integer> result = eventService.addOrEdit(eventReq);
    	 if(ResultCode.C200.getCode().equals(result.getCode())){
    		 return "redirect:allReport";
    	 }else{
    		 map.addAttribute("result", result);
    		 return "error";
    	 }
    	 
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
    
    /**
     * 上报
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/higherUp", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> higherUp(EventReq eventReq) {
    	return eventService.higherUp(eventReq);
    }
    /**
     * 处理
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> handle(EventReq eventReq) {
    	return eventService.handle(eventReq);
    }
}
