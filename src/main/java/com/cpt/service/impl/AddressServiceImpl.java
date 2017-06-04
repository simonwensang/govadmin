package com.cpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.mapper.AddressMapper;
import com.cpt.model.Address;
import com.cpt.model.AddressExample;
import com.cpt.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<Address> selectByLevel(Byte level) {
		AddressExample example = new AddressExample();
		AddressExample.Criteria criteria =example.createCriteria();
		criteria.andLevelEqualTo(level);
		return addressMapper.selectByExample(example);
	}

}
