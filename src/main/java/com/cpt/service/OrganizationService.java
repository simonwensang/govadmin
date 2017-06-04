package com.cpt.service;

import java.util.List;

import com.cpt.model.Organization;


public interface OrganizationService {

	public  String getTreeNode();

	public List<Organization> selectByLevel(Byte level); 
	
	public List<Organization> select(); 
	
	public Organization selectById(Long id);
}
