package com.cpt.mapper;

import com.cpt.model.EventResponse;
import com.cpt.model.EventResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventResponseMapper {
    int countByExample(EventResponseExample example);

    int deleteByExample(EventResponseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EventResponse record);

    int insertSelective(EventResponse record);

    List<EventResponse> selectByExample(EventResponseExample example);

    EventResponse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EventResponse record, @Param("example") EventResponseExample example);

    int updateByExample(@Param("record") EventResponse record, @Param("example") EventResponseExample example);

    int updateByPrimaryKeySelective(EventResponse record);

    int updateByPrimaryKey(EventResponse record);
}