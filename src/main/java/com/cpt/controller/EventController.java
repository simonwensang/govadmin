package com.cpt.controller;

import java.util.Arrays;
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
import com.cpt.common.constant.EventStatus;
import com.cpt.common.constant.EventType;
import com.cpt.mapper.ext.RoleExtMapper;
import com.cpt.model.Address;
import com.cpt.model.Role;
import com.cpt.req.EventReq;
import com.cpt.service.AddressService;
import com.cpt.service.CustomerService;
import com.cpt.service.EventService;
import com.cpt.service.UserService;
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
	private  AddressService addressService;
	
	@Autowired 
	private UserService userService ;
	@Autowired 
	private RoleExtMapper roleExtMapper;
	 /**
     * 事件分页查询
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/allReport")
    public ModelAndView allReport(ModelAndView mav,EventReq eventReq) {
    	eventReq.setEventType(null==eventReq.getEventType()?1:eventReq.getEventType()) ;
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
    	mav.addObject("addressList", addressList);
    	mav.addObject("result", result);
    	mav.addObject("eventType", eventReq.getEventType());
    	mav.addObject("user",userService.getUser());
        mav.setViewName("event/allReport");
        mav.addObject("cur_module","event_List");
        switch(eventReq.getEventType()){
        	case (byte)1:mav.addObject("cur_menu","zaff_List") ;break;
        	case (byte)2:mav.addObject("cur_menu","jzgl_list") ;break;
        	case (byte)3:mav.addObject("cur_menu","mdjf_list") ;break;
        	case (byte)4:mav.addObject("cur_menu","jcdj_list") ;break;
        	case (byte)5:mav.addObject("cur_menu","wmfw_list") ;break;
        	case (byte)6:mav.addObject("cur_menu","qtfw_list") ;break;
        	default : break;
        }
        
        return mav;
    }
    /**
     * 未处理的
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/untreated", method = RequestMethod.GET)
    public ModelAndView untreated(ModelAndView mav,EventReq eventReq) {
    	eventReq.setEventStatusList(Arrays.asList(EventStatus.INIT.getKey(),EventStatus.AUDIT.getKey(),EventStatus.HANDLE.getKey()));
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
    	mav.addObject("addressList", addressList);
    	mav.addObject("result", result);
    	mav.addObject("user",userService.getUser());
        mav.setViewName("event/untreated");
        mav.addObject("cur_module","account");
        mav.addObject("cur_menu","event_untreated") ;
        return mav;
    }
    
    /**
     * 已经处理的
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/treated", method = RequestMethod.GET)
    public ModelAndView treated(ModelAndView mav,EventReq eventReq) {
    	eventReq.setEventStatusList(Arrays.asList(EventStatus.CLOSE.getKey()));
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
    	mav.addObject("addressList", addressList);
    	mav.addObject("result", result);
    	mav.addObject("user",userService.getUser());
        mav.setViewName("event/treated");
        mav.addObject("cur_module","account");
        mav.addObject("cur_menu","event_treated") ;
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
        mav.addObject("user",userService.getUser());
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
        mav.addObject("event", eventService.detail(id));
        mav.setViewName("event/detail");
        mav.addObject("user",userService.getUser());
        return mav;
    }
    /**
     * 审批
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/approval", method = RequestMethod.GET)
    public ModelAndView approval(ModelAndView mav, Integer id) {
    	mav.addObject("event", eventService.detail(id));
	    mav.setViewName("event/approval");
	    mav.addObject("user",userService.getUser());
        return mav;
    }
    /**
     * 处理
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public ModelAndView manage(ModelAndView mav, Integer id) {
    	mav.addObject("event", eventService.detail(id));
    	mav.addObject("user",userService.getUser());
	    mav.setViewName("event/manage");
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
    	List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
    	eventType = null==eventType?1:eventType;
    	mav.addObject("eventType", new EnumBean(eventType,EventType.getValueByKey(eventType)));
    	mav.addObject("addressList", addressList);
        mav.setViewName("event/submission");
        mav.addObject("user",userService.getUser());
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
        mav.addObject("user",userService.getUser());
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
    public String sendHandler(ModelMap map ,EventReq eventReq) {
    	 Result<Integer> result = eventService.sendHandler(eventReq);
    	 
    	 if(ResultCode.C200.getCode().equals(result.getCode())){
    		 return "redirect:allReport";
    	 }else{
    		 map.addAttribute("result", result);
    		 return "error";
    	 }
    }
    
    /**
     * 上报
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/higherUp", method = RequestMethod.GET)
    public String higherUp(ModelMap map ,EventReq eventReq) {
     
    	Result<Integer> result = eventService.higherUp(eventReq);
   	 
	   	 if(ResultCode.C200.getCode().equals(result.getCode())){
	   		 return "redirect:allReport";
	   	 }else{
	   		 map.addAttribute("result", result);
	   		 return "error";
	   	 }
    }
    /**
     * 处理
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public String handle(ModelMap map ,EventReq eventReq) {
    	
    	 Result<Integer> result = eventService.handle(eventReq);
    	 
    	 if(ResultCode.C200.getCode().equals(result.getCode())){
    		 return "redirect:allReport";
    	 }else{
    		 map.addAttribute("result", result);
    		 return "error";
    	 }
    }
}
