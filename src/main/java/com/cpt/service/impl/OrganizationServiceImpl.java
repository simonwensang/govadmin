package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.model.Organization;
import com.cpt.model.OrganizationExample;
import com.cpt.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Override
	public List<Organization> select() {
		OrganizationExample example = new OrganizationExample();
		return organizationMapper.selectByExample(example);
	}

	@Override
	public List<Organization> selectByLevel(Byte level) {
		OrganizationExample example = new OrganizationExample();
		OrganizationExample.Criteria criteria =example.createCriteria();
		criteria.andLevelEqualTo(level);
		return organizationMapper.selectByExample(example);
	}
	
	public Organization selectById(Long id) {
		return organizationMapper.selectByPrimaryKey(id);
	}
	@Override
	public String getTreeNode() {
		OrganizationExample example = new OrganizationExample();
		//OrganizationExample.Criteria criteria =example.createCriteria();
		//criteria.andLevelNotEqualTo(Constants.LEVEL_1);
		List<Organization> organizations = organizationMapper.selectByExample(example);
		JSONArray jsonArray=new JSONArray();  
		for(Organization organization:organizations)  
	    {  
	        JSONObject jsonObject=new JSONObject();  
	        jsonObject.put("id",organization.getId());  
	        jsonObject.put("pId",organization.getParentId());  
	        jsonObject.put("name",organization.getName());  
	        if(organization.getId()==1){
	        	jsonObject.put("open","true");
	        }  
            //判断所选择节点是否是父节点，如果是设置isParent属性为true,不是设置为false  
	        if(organization.getLevel().byteValue() <(byte)4 )  
	        {  
	            jsonObject.put("isParent","true");  
	        }else {  
	            jsonObject.put("isParent","false");  
	        }  
	        jsonArray.add(jsonObject);  
	    }  
		 return jsonArray.toJSONString();
	}

}
