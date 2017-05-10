package com.cpt.mapper;

import com.cpt.model.EventHandleLog;
import com.cpt.model.EventHandleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventHandleLogMapper {
    int countByExample(EventHandleLogExample example);

    int deleteByExample(EventHandleLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EventHandleLog record);

    int insertSelective(EventHandleLog record);

    List<EventHandleLog> selectByExample(EventHandleLogExample example);

    EventHandleLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EventHandleLog record, @Param("example") EventHandleLogExample example);

    int updateByExample(@Param("record") EventHandleLog record, @Param("example") EventHandleLogExample example);

    int updateByPrimaryKeySelective(EventHandleLog record);

    int updateByPrimaryKey(EventHandleLog record);
}