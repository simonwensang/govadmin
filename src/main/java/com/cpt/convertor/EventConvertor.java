package com.cpt.convertor;

import java.util.List;

import com.cpt.model.EventAttachment;
import org.apache.commons.lang.StringUtils;
import org.springframework.cglib.beans.BeanCopier;

import com.cpt.common.constant.EventStatus;
import com.cpt.common.constant.EventType;
import com.cpt.common.constant.Grade;
import com.cpt.model.Event;
import com.cpt.req.EventReq;
import com.cpt.vo.EventVo;
import com.google.common.collect.Lists;

public class EventConvertor {
	
    private static final BeanCopier beanCopierForReqToEvent = BeanCopier.create(EventReq.class,Event.class,false);
    private static final BeanCopier beanCopierForEventVo = BeanCopier.create(Event.class,EventVo.class,false);
    
    public static Event reqToEvent(EventReq eventReq) {
        if (eventReq == null) {
            return null;
        }
        Event event = new Event();
        beanCopierForReqToEvent.copy(eventReq, event, null);
        /*if(StringUtils.isNotBlank(projectReq.getTenderTime())){
        	 project.setTenderTime(DateUtils.parseStr(projectReq.getTenderTime(), DateUtils.dateTimeString));
        }*/

        if(eventReq.getEventAttachmentList()!=null && !eventReq.getEventAttachmentList().isEmpty()){
            List<EventAttachment> eventAttachments = Lists.newArrayList();

            for (String attachment : eventReq.getEventAttachmentList()){
                if(StringUtils.isNotBlank(attachment)){
                    EventAttachment eventAttachment = new EventAttachment();
                    eventAttachment.setAttachment(attachment);
                    eventAttachment.setAttachmentName(StringUtils.substringAfterLast(attachment, "/"));
                    eventAttachments.add(eventAttachment);
                }
            }

            event.setEventAttachmentList(eventAttachments);
        }
        return event;
    }

    public static EventVo toEventVo(Event event) {
        if (event == null) {
            return null;
        }
        EventVo eventVo = new EventVo();
        beanCopierForEventVo.copy(event, eventVo, null);
       /* if(null!=event.getEventHandleLogList()){
        	eventVo.setEventHandleLogVoList(EventHandleLogConvertor.toEventHandleLogVoList(event.getEventHandleLogList()));
        }*/
        return eventVo;
    }
    public static  List<EventVo>  toEventVoList(List<Event> eventList) {
        if (eventList == null ) {
            return null;
        }
        List<EventVo> eventVoList = Lists.newArrayList();
        for(Event  event  : eventList){
        	eventVoList.add(toEventVo(event));
        }
        return eventVoList;
    }
    
    public static List<EventVo> fixExcel(List<EventVo> eventList){
    	for(EventVo  event  : eventList){
    		event.setEventTypeStr(EventType.getValueByKey(event.getEventType()));
    		event.setGradeStr(Grade.getValueByKey(event.getGrade()));
    		event.setEventStatusStr(EventStatus.getValueByKey(event.getEventStatus()));
        }
    	return eventList;
    }
}
