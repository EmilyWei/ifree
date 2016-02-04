package com.mittop.ifree.business.dao.impl;

import org.springframework.stereotype.Repository;

import com.mittop.ifree.base.dao.BaseDaoImpl;
import com.mittop.ifree.business.dao.BusinessInstDao;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;

@Repository("businessInstDao")
public class BusinessInstDaoImpl extends BaseDaoImpl<BusinessInst,String> implements BusinessInstDao{

	@Override
	public BusinessInst get(FormContext formContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(BusinessInst businessInst, FormContext formContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(FormContext formContext) {
		// TODO Auto-generated method stub
		
	}

	

}
