package com.cpt.mapper.ext;

import com.cpt.model.EventAttachment;

import java.util.List;

public interface EventAttachmentExtMapper {


    int insertBatch(List<EventAttachment> record);


}