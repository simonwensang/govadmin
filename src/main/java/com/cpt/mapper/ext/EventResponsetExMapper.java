package com.cpt.mapper.ext;

import com.cpt.model.EventResponse;
import com.cpt.model.EventResponseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventResponsetExMapper {

    int insertList(List<EventResponse> list);

}