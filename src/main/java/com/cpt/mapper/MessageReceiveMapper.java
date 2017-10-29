package com.cpt.mapper;

import com.cpt.model.MessageReceive;
import com.cpt.model.MessageReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageReceiveMapper {
    int countByExample(MessageReceiveExample example);

    int deleteByExample(MessageReceiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageReceive record);

    int insertSelective(MessageReceive record);

    List<MessageReceive> selectByExample(MessageReceiveExample example);

    MessageReceive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageReceive record, @Param("example") MessageReceiveExample example);

    int updateByExample(@Param("record") MessageReceive record, @Param("example") MessageReceiveExample example);

    int updateByPrimaryKeySelective(MessageReceive record);

    int updateByPrimaryKey(MessageReceive record);
}