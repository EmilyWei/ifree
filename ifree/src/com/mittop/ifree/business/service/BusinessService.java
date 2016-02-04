package com.mittop.ifree.business.service;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.business.model.def.Business;

public interface BusinessService {
	
	public Business getBusiness(String name)  throws IfreeException;

	public Business makeBusiness(String tableName)  throws IfreeException;

	
	public void makeSchema(Business business )  throws IfreeException;
	
	public Business get(String businessId)  throws IfreeException;

	
	public void remove(String businessId)  throws IfreeException;
	
	public void save(Business business)  throws IfreeException;


}
