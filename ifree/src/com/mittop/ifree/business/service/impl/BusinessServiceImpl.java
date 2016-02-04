package com.mittop.ifree.business.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.base.service.BaseService;
import com.mittop.ifree.business.dao.BusinessDao;
import com.mittop.ifree.business.model.def.Attribute;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.def.Form;
import com.mittop.ifree.business.model.def.FormPropertyStyle;
import com.mittop.ifree.business.model.def.ListPropertyStyle;
import com.mittop.ifree.business.model.inst.AttributeInst;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;
import com.mittop.ifree.business.service.BusinessService;
import com.mittop.ifree.business.xml.BusinessUnmarshaller;
import com.mittop.ifree.util.xml.Marshaller;

@Service("businessService")
public class BusinessServiceImpl extends BaseService implements BusinessService{

	@Resource(name = "businessDao")
	BusinessDao businessDao;
	
	public Business makeBusiness(String tableName) throws IfreeException {
		Business business = businessDao.makeBusiness(tableName);
		doMakeBusiness(business);
		return business;
	}




	private void doMakeBusiness(Business business) {
		Form form = new Form();
		com.mittop.ifree.business.model.def.List list = new com.mittop.ifree.business.model.def.List();
		form.setName("default");
		list.setName("default");
		List<Attribute> attributes =  business.getAttributes();
		for(int i=0;i<attributes.size();i++){
			
			FormPropertyStyle formPropertyStyle = new FormPropertyStyle();
			formPropertyStyle.setAttribute(attributes.get(i));
			form.addFormPropertyStyle(formPropertyStyle);
			

			ListPropertyStyle listPropertyStyle = new ListPropertyStyle();
			listPropertyStyle.setAttribute(attributes.get(i));
			list.addListPropertyStyle(listPropertyStyle);
			
			
		}
		business.addForm(form);
		
	}




	public Business get(String businessId) {
		return businessDao.get(businessId);
	}




	public void save(Business business)   throws IfreeException{
		
		Marshaller marshaller = new Marshaller(business);
		try {
			String def = marshaller.marshall();
			business.setDef(def);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IfreeException(e);
		}
		
		businessDao.save(business);
	}




	public void remove(String businessId) throws IfreeException {
		businessDao.remove();
	}




	public BusinessServiceImpl() {
	}
    
    

	public Business getBusiness(String name){
		
		Business business = this.businessDao.getBusinessByName(name);
		
		String xml = business.getDef();
		try {
			BusinessUnmarshaller businessUnmarshaller = new BusinessUnmarshaller(xml);
			businessUnmarshaller.parse();
			business = businessUnmarshaller.getBusiness();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return business;
	}
	

	
	
	

	private BusinessInst buildBusinessInst(String businessName) {
		BusinessInst businessInst = new BusinessInst();
		Business business = this.getBusiness(businessName);
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
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void makeSchema(Business business) throws IfreeException {
		this.businessDao.makeSchema(business);
	}


	
	
}
