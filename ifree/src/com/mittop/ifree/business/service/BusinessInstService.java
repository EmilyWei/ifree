package com.mittop.ifree.business.service;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;

public interface BusinessInstService {

	public Business getBusiness(String businessName) throws IfreeException;
	
	public BusinessInst getBusinessInst(FormContext formContext) throws IfreeException;

	public void remove(FormContext formContext) throws IfreeException;

	public void save(BusinessInst businessInst, FormContext formContext) throws IfreeException;

	public void remove(String businessInstId, FormContext formContext) throws IfreeException;
}
