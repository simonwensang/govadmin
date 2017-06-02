package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpt.common.constant.EventStatus;
import com.cpt.common.constant.EventType;
import com.cpt.mapper.EventMapper;
import com.cpt.mapper.ext.EventExtMapper;
import com.cpt.model.EventExample;
import com.cpt.req.StatisticsReq;
import com.cpt.service.StatisticsService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.DepartmentExpenses;
import com.cpt.vo.EchartVo;
import com.google.common.collect.Lists;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Resource
	private UserCommonService userCommonService;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventExtMapper eventExtMapper;
	
	@Override
	public List<EchartVo> getStatistics(StatisticsReq statisticsReq) {
		List<EchartVo> echartVoList = Lists.newArrayList();
		EventType[] eventTypes = EventType.values();
		for (int i = 0; i < eventTypes.length; i++) {
			EchartVo echartVo =new EchartVo();
			JSONArray jsonArray=new JSONArray(); 
			 
	        JSONObject endEvent=new JSONObject();  
	        endEvent.put("name","已办结");  
	        endEvent.put("value",this.countStatusEvent(eventTypes[i].getKey(), EventStatus.CLOSE.getKey()));
	        jsonArray.add(endEvent); 
	        
	        JSONObject unEvent=new JSONObject();
	        unEvent.put("name","未办结");  
	        unEvent.put("value",this.countNotStatusEvent(eventTypes[i].getKey(), EventStatus.CLOSE.getKey()));
	        jsonArray.add(unEvent);  
			echartVo.setValue(jsonArray.toJSONString());
			 
			echartVoList.add(echartVo);
		}
		 
		return echartVoList;
		
	}

	
	private Integer countStatusEvent(Byte type , Byte status ){
		EventExample example = new EventExample();
		EventExample.Criteria criteria = example.createCriteria();
		criteria.andEventTypeEqualTo(type);
		criteria.andEventStatusEqualTo(status);
		return eventMapper.countByExample(example);
	}
	
	private Integer countNotStatusEvent(Byte type , Byte status ){
		EventExample example = new EventExample();
		EventExample.Criteria criteria = example.createCriteria();
		criteria.andEventTypeEqualTo(type);
		criteria.andEventStatusNotEqualTo(status);
		return eventMapper.countByExample(example);
	}
}
