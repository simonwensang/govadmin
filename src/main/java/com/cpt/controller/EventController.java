package com.cpt.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
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
import com.cpt.common.constant.RoleCode;
import com.cpt.common.util.DateUtils;
import com.cpt.common.util.ExcelUtils;
import com.cpt.convertor.EventConvertor;
import com.cpt.mapper.ext.RoleExtMapper;
import com.cpt.model.Address;
import com.cpt.model.User;
import com.cpt.req.EventReq;
import com.cpt.service.AddressService;
import com.cpt.service.CustomerService;
import com.cpt.service.EventService;
import com.cpt.service.OrganizationService;
import com.cpt.service.UserService;
import com.cpt.vo.EnumBean;
import com.cpt.vo.EventVo;
import com.cpt.vo.WorkFlowVo;

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
	@Autowired 
	private  OrganizationService organizationService;
	  private static final String EXPORT_RECORD_TEMPLATE = "templates/excel/event_record.xlsx";
	/**
     * 未处理的
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer> excel(ModelAndView mav,EventReq eventReq, HttpServletResponse response) {
    	eventReq.setEventType(null==eventReq.getEventType()?1:eventReq.getEventType()) ;
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	ExcelUtils.write2excel(EXPORT_RECORD_TEMPLATE, "event"+DateUtils.getCurrentDay(DateUtils.dateTimeString4FileName)+".xlsx", EventConvertor.fixExcel(result.getRows()), response);
		return null;
    }
    /**
     * 未处理的
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/excelTreated", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer> excelTreated(ModelAndView mav,EventReq eventReq, HttpServletResponse response) {
    	eventReq.setEventStatusList(Arrays.asList(EventStatus.CLOSE.getKey()));
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	ExcelUtils.write2excel(EXPORT_RECORD_TEMPLATE, "treated"+DateUtils.getCurrentDay(DateUtils.dateTimeString4FileName)+".xlsx", EventConvertor.fixExcel(result.getRows()), response);
		return null;
    }
    /**
     * 未处理的
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/excelUntreated", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer> excelUntreated(ModelAndView mav,EventReq eventReq, HttpServletResponse response) {
    	eventReq.setEventStatusList(Arrays.asList(EventStatus.INIT.getKey(),EventStatus.AUDIT.getKey(),EventStatus.HANDLE.getKey()));
    	PageResult<EventVo> result = eventService.allReport(eventReq);
    	ExcelUtils.write2excel(EXPORT_RECORD_TEMPLATE, "untreated"+DateUtils.getCurrentDay(DateUtils.dateTimeString4FileName)+".xlsx", EventConvertor.fixExcel(result.getRows()), response);
		return null;
    }
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
    	mav.addObject("eventReq", eventReq);
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
    @RequestMapping(value = "/untreated")
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
    @RequestMapping(value = "/treated")
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
     * @param eventReq
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
    	User user = userService.getUser();
    	EventVo event = eventService.detail(id);
    	/*if(user.getId().intValue()!=event.getAuditorId()
    		&&user.getId().intValue()!=event.getCcUserId()
    		&&user.getId().intValue()!=event.getCommitUserId()
    		&&user.getId().intValue()!=event.getHandlerId()
    		&&user.getId().intValue()!=event.getResponsibleId()
    		&&!RoleCode.ADMIN.getKey().equals(user.getRole().getRoleCode())
    		&&!RoleCode.SUPERUSER.getKey().equals(user.getRole().getRoleCode())){
	   		 mav.addObject("result", new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc()));
	   		 mav.setViewName("error");
	   		 return mav;
    	}*/
        mav.addObject("event", event);
        mav.setViewName("event/detail");
        mav.addObject("user",user);
        mav.addObject("cur_module","event_List");
        return mav;
    }

    /**
     * 详情
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView mav, Integer id) {
        User user = userService.getUser();
        //只有 网格人员可以提报
        if(!RoleCode.VILLAGE.getKey().equals(user.getRole().getRoleCode())){
            mav.addObject("result", new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc()));
            mav.setViewName("error");
            return mav;
        }
        List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
        List<EnumBean> eventTypeList = Lists.newArrayList();
        for (EventType eventType:EventType.values()
             ) {
            eventTypeList.add(new EnumBean(eventType.getKey(),eventType.getValue()));
        }
        mav.addObject("eventTypeList",eventTypeList);
        mav.addObject("addressList", addressList);

        EventVo event = eventService.detail(id);
        mav.addObject("event", event);
        mav.setViewName("event/edit");
        mav.addObject("user",user);
        mav.addObject("cur_module","event_List");
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
    	User user = userService.getUser();
    	EventVo event = eventService.detail(id);
    	if(user.getId().intValue()!=event.getAuditorId()){
	   		 mav.addObject("result", new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc()));
	   		 mav.setViewName("error");
	   		 return mav;
    	}
    	eventService.updateWorkFlow(id.longValue(), user.getId());
        mav.addObject("event", event);
	    mav.setViewName("event/approval");
	    mav.addObject("organizationList",organizationService.select() );
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
    	User user = userService.getUser();
    	//只有 网格人员可以提报
    	if(!RoleCode.VILLAGE.getKey().equals(user.getRole().getRoleCode())){
    		 mav.addObject("result", new Result<Integer>(ResultCode.C402.getCode(),ResultCode.C402.getDesc()));
    		 mav.setViewName("error");
    		 return mav;
    	}
    	List<Address> addressList = addressService.selectByLevel(Constants.LEVEL_4);
    	eventType = null==eventType?1:eventType;
    	mav.addObject("eventType", new EnumBean(eventType,EventType.getValueByKey(eventType)));
    	mav.addObject("addressList", addressList);
        mav.setViewName("event/submission");
        mav.addObject("user",user);
        return mav;
    }
    /**
     * 提报
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/submission2", method = RequestMethod.GET)
    public ModelAndView submission2(ModelAndView mav, Integer id) {
        mav.addObject("event", eventService.detail(id));
        mav.addObject("user",userService.getUser());
        mav.setViewName("event/submission2");
        return mav;
    }

    /**
     * 提报
     *
     * @param eventReq
     * @return
     */
    @RequestMapping(value = "/commit", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer> commit(EventReq eventReq) {
        return eventService.commit(eventReq);
    }
    /**
     * 工程创建页面
     *
     * @param mav
     * @param id
     * @return
     */
   /* @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("event/event_detail");
        mav.addObject("user",userService.getUser());
        return mav;
    }*/
  
    /**
     * 增加或者修改
     *
     * @param map
     * @param eventReq
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(ModelMap map , EventReq eventReq) {
    	 return eventService.addOrEdit(eventReq);
    }
    /**
     *  删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> delete(Integer id) {
    	 return eventService.delete(id);
    }
    /**
     * 派遣
     *
     * @param map
     * @param eventReq
     * @return
     */
    @RequestMapping(value = "/sendHandler", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> sendHandler(ModelMap map ,EventReq eventReq) {
    	return eventService.sendHandler(eventReq);
    }
    
    /**
     * 上报
     *
     * @param map
     * @param eventReq
     * @return
     */
    @RequestMapping(value = "/higherUp", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer> higherUp(ModelMap map ,EventReq eventReq) {
    	return eventService.higherUp(eventReq);
    }
    /**
     * 处理
     *
     * @param map
     * @param eventReq
     * @return
     */
    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> handle(ModelMap map ,EventReq eventReq) {
    	
    	return eventService.handle(eventReq);
    }
    
    /**
     * 得到最新审核记录
     *
     * @return
     */
    @RequestMapping(value = "/workFlow", method = RequestMethod.POST)
    @ResponseBody
    public Result<WorkFlowVo> getWorkFlow() {
    	return eventService.getWorkFlow();
    }
}
