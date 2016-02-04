package com.mittop.ifree.business.dao;

import com.mittop.ifree.business.model.def.Business;

public interface BusinessDao {

	public Business makeBusiness(String tableName);
	
	
	public void makeSchema(Business business );
	
	public Business get(String businessId);
	
	public Business getBusinessByName(String businessName);
	
	public void save(Business business );
	
	public void remove();
}
