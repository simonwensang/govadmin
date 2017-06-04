package com.cpt.service;

import java.util.List;

import com.cpt.model.Address;

public interface AddressService {
	List<Address> selectByLevel(Byte level); 
}
