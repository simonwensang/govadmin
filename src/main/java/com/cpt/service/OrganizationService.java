package com.cpt.service;

import java.util.List;

import com.cpt.model.Organization;


public interface OrganizationService {

	public  String getTreeNode();

	List<Organization> selectByLevel(Byte level); 
	
}
