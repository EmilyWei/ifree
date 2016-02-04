package com.mittop.ifree.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.base.service.BaseService;
import com.mittop.ifree.business.dao.BusinessInstDao;
import com.mittop.ifree.business.model.def.Attribute;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.inst.AttributeInst;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;
import com.mittop.ifree.business.service.BusinessInstService;
import com.mittop.ifree.business.service.BusinessService;

@Service("businessInstService")
public class BusinessInstServiceImpl extends BaseService implements BusinessInstService{

	@Resource(name = "businessInstDao")
	BusinessInstDao businessInstDao;
	
	
	@Resource(name = "businessService")
	BusinessService businessService;
	
	

	public Business getBusiness(String businessName) throws IfreeException {
		return businessService.getBusiness(businessName);
	}




	public BusinessInstServiceImpl() {
	}
   
    
    

	private BusinessInst getBusinessInst(Business business) {
		BusinessInst businessInst = new BusinessInst();
		List<Attribute> attributes = business.getAttributes();
		for(int i=0;i<attributes.size();i++){
			AttributeInst attributeInst = new AttributeInst();
			attributeInst.setAttribute(attributes.get(i));
			businessInst.addAttributeInst(attributeInst);
		}
		businessInst.setBusiness(business);
		return businessInst;
	}


	
	

	private BusinessInst buildBusinessInst(String businessName) throws IfreeException {
		BusinessInst businessInst = new BusinessInst();
		Business business = this.businessService.getBusiness(businessName);
		List<Attribute> attributes = business .getAttributes();
		for(int i=0;i<attributes.size();i++){
			AttributeInst attributeInst = new AttributeInst();
			attributeInst.setAttribute(attributes.get(i));
			businessInst.addAttributeInst(attributeInst);
			attributeInst.setValue(attributes.get(i).getName());
		}
		businessInst.setBusiness(business);
		return businessInst;
	}

	private BusinessInst doGetBusinessInst(FormContext formContext) {
		return this.businessInstDao.get(formContext);
	}




	@Override
	public BusinessInst getBusinessInst(FormContext formContext) throws IfreeException {
		BusinessInst businessInst = null;
		if(formContext.getBusinessInstId() == null){
		businessInst = this.buildBusinessInst(formContext.getBusinessName());
	}else{
		businessInst = this.doGetBusinessInst(formContext);
	}
		return businessInst;
	}




	@Override
	public void save(BusinessInst businessInst, FormContext formContext) throws IfreeException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void remove(String businessInstId, FormContext formContext) throws IfreeException {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void remove(FormContext formContext) throws IfreeException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
