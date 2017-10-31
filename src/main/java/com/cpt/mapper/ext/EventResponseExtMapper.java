package com.cpt.mapper.ext;

import com.cpt.model.EventResponse;

import java.util.List;

/**
 * Created by souibun on 2017/10/31.
 */
public interface EventResponseExtMapper {
    int insertList(List<EventResponse> list);
}
