package com.cpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.EventStatus;
import com.cpt.common.constant.EventType;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.util.DateUtils;
import com.cpt.mapper.EventMapper;
import com.cpt.mapper.StatisticsMapper;
import com.cpt.mapper.ext.EventExtMapper;
import com.cpt.model.EventExample;
import com.cpt.model.Statistics;
import com.cpt.model.StatisticsExample;
import com.cpt.req.StatisticsReq;
import com.cpt.service.StatisticsService;
import com.cpt.service.UserCommonService;
import com.cpt.vo.EchartVo;
import com.cpt.vo.StatisticsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Resource
	private UserCommonService userCommonService;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventExtMapper eventExtMapper;
	@Autowired
	private StatisticsMapper statisticsMapper;
	
 
	@Override
	public Result<Integer> addOrEdit(Statistics statistics) {
		if(StringUtils.isBlank( statistics.getContent())){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		statistics.setCreator(userCommonService.getUser().getName());
		statistics.setCreatorId(userCommonService.getUserId());
		if(statistics.getId()==null){
			return Result.newResult(this.insert(statistics));
		}else{
			return Result.newResult(this.update(statistics));
		}
	}

	@Override
	public Result<Integer> delete(Integer id) {
		return  Result.newResult(statisticsMapper.deleteByPrimaryKey(id));
	}

	private int insert(Statistics statistics){
		return statisticsMapper.insertSelective(statistics);
	}

	private int update(Statistics statistics){
		return statisticsMapper.updateByPrimaryKeySelective(statistics);
	}
	@Override
	public PageResult<Statistics> pageList(StatisticsReq pageParam) {
		//分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getRows());
        //当前页列表
        StatisticsExample example = new StatisticsExample();
        StatisticsExample.Criteria criteria= example.createCriteria();
        if(StringUtils.isNoneBlank(pageParam.getStartTime())){
        	criteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.parseStr(pageParam.getStartTime(), DateUtils.dateString ));
        }
        if(StringUtils.isNoneBlank(pageParam.getEndTime())){
        	criteria.andCreateTimeLessThanOrEqualTo(DateUtils.parseStr(pageParam.getEndTime(),DateUtils.dateString ));
        }
        List<Statistics> messages = statisticsMapper.selectByExample(example);
        //构造分页结果
        PageResult<Statistics> pageResult = PageResult.newPageResult(messages, ((Page<Statistics>)messages).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public StatisticsVo getStatistics(StatisticsReq statisticsReq) {
		StatisticsVo statisticsVo = new StatisticsVo();
		statisticsVo.setPublicSecurity(this.getEchartVo(EventType.PUBLIC_SECURITY,statisticsReq));
		statisticsVo.setDispute(this.getEchartVo(EventType.DISPUTE,statisticsReq));
		statisticsVo.setLivelihoodServices(this.getEchartVo(EventType.LIVELIHOOD_SERVICES,statisticsReq));
		statisticsVo.setOtherServices(this.getEchartVo(EventType.OTHER_SERVICES,statisticsReq));
		statisticsVo.setPartyBasicOrganization(this.getEchartVo(EventType.PARTY_BASIC_ORGANIZATION,statisticsReq));
		statisticsVo.setTownManagement(this.getEchartVo(EventType.TOWN_MANAGEMENT,statisticsReq));
		return statisticsVo;
		
	}

	private EchartVo getEchartVo(EventType eventType,StatisticsReq statisticsReq){
		EchartVo echartVo =new EchartVo();
		JSONArray jsonArray=new JSONArray(); 
        JSONObject endEvent=new JSONObject();  
        endEvent.put("name","已办结");  
        endEvent.put("value",this.countStatusEvent(eventType.getKey(), EventStatus.CLOSE.getKey(),statisticsReq));
        jsonArray.add(endEvent); 
        JSONObject unEvent=new JSONObject();
        unEvent.put("name","未办结");  
        unEvent.put("value",this.countNotStatusEvent(eventType.getKey(), EventStatus.CLOSE.getKey(),statisticsReq));
        jsonArray.add(unEvent);  
        echartVo.setValue(jsonArray.toJSONString());
        if(StringUtils.isNoneBlank(statisticsReq.getStartTime())){
        	 echartVo.setStartTime(statisticsReq.getStartTime());
        }else{
       	 echartVo.setStartTime("-");
       }
        if(StringUtils.isNoneBlank(statisticsReq.getEndTime())){
        	 echartVo.setEndTime(statisticsReq.getEndTime());
        }else{
        	 echartVo.setEndTime("-");
        }
       
        return echartVo;
	}
	
	
	private Integer countStatusEvent(Byte type , Byte status ,StatisticsReq pageParam){
		EventExample example = new EventExample();
		EventExample.Criteria criteria = example.createCriteria();
		criteria.andEventTypeEqualTo(type);
		criteria.andEventStatusEqualTo(status);
		if(StringUtils.isNoneBlank(pageParam.getStartTime())){
        	criteria.andCommitTimeGreaterThanOrEqualTo(DateUtils.parseStr(pageParam.getStartTime(), DateUtils.dateString ));
        }
        if(StringUtils.isNoneBlank(pageParam.getEndTime())){
        	criteria.andCommitTimeLessThanOrEqualTo(DateUtils.parseStr(pageParam.getEndTime(),DateUtils.dateString ));
        }
		return eventMapper.countByExample(example);
	}
	
	private Integer countNotStatusEvent(Byte type , Byte status,StatisticsReq pageParam ){
		EventExample example = new EventExample();
		EventExample.Criteria criteria = example.createCriteria();
		criteria.andEventTypeEqualTo(type);
		criteria.andEventStatusNotEqualTo(status);
		if(StringUtils.isNoneBlank(pageParam.getStartTime())){
        	criteria.andCommitTimeGreaterThanOrEqualTo(DateUtils.parseStr(pageParam.getStartTime(), DateUtils.dateString ));
        }
        if(StringUtils.isNoneBlank(pageParam.getEndTime())){
        	criteria.andCommitTimeLessThanOrEqualTo(DateUtils.parseStr(pageParam.getEndTime(),DateUtils.dateString ));
        }
		return eventMapper.countByExample(example);
	}
}
