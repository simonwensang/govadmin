package com.cpt.mapper.ext;

import com.cpt.model.EventAttachment;
import com.cpt.model.EventAttachmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventAttachmentExtMapper {


    int insertBatch(List<EventAttachment> record);


}