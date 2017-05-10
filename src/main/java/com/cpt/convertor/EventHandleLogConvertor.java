package com.cpt.convertor;

import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.EventHandleLog;
import com.cpt.vo.EventHandleLogVo;
import com.google.common.collect.Lists;

public class EventHandleLogConvertor {

    private static final BeanCopier beanCopierForEventHandleLogVo = BeanCopier.create(EventHandleLog.class,EventHandleLogVo.class,false);
    
    public static EventHandleLogVo toEventHandleLogVo(EventHandleLog eventHandleLog) {
        if (eventHandleLog == null) {
            return null;
        }
        EventHandleLogVo eventHandleLogVo = new EventHandleLogVo();
        beanCopierForEventHandleLogVo.copy(eventHandleLog, eventHandleLogVo, null);
        return eventHandleLogVo;
    }
    public static  List<EventHandleLogVo>  toEventHandleLogVoList(List<EventHandleLog> eventHandleLogList) {
        if (eventHandleLogList == null ) {
            return null;
        }
        List<EventHandleLogVo> eventHandleLogVoList = Lists.newArrayList();
        for(EventHandleLog  eventHandleLog  : eventHandleLogList){
        	eventHandleLogVoList.add(toEventHandleLogVo(eventHandleLog));
        }
        return eventHandleLogVoList;
    }

}
