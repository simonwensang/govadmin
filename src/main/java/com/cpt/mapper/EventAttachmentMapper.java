package com.cpt.mapper;

import com.cpt.model.EventAttachment;
import com.cpt.model.EventAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventAttachmentMapper {
    int countByExample(EventAttachmentExample example);

    int deleteByExample(EventAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EventAttachment record);

    int insertSelective(EventAttachment record);

    List<EventAttachment> selectByExample(EventAttachmentExample example);

    EventAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EventAttachment record, @Param("example") EventAttachmentExample example);

    int updateByExample(@Param("record") EventAttachment record, @Param("example") EventAttachmentExample example);

    int updateByPrimaryKeySelective(EventAttachment record);

    int updateByPrimaryKey(EventAttachment record);
}