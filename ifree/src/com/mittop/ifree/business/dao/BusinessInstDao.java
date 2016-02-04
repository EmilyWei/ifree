package com.mittop.ifree.business.dao;

import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;

public interface BusinessInstDao {

	
	public BusinessInst get(FormContext formContext );
	
	public void save(BusinessInst businessInst,FormContext formContext);
	
	public void remove(FormContext formContext);
}
