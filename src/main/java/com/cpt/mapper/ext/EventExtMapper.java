package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Event;
import com.cpt.req.EventReq;

public interface EventExtMapper {
   
    List<Event> pageList(EventReq eventReq);
    
    int insertSelective(Event record);
    
}