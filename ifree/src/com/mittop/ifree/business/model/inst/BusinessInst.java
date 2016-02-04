package com.mittop.ifree.business.model.inst;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.mittop.ifree.base.model.BaseObject;
import com.mittop.ifree.business.model.def.Business;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class BusinessInst  extends BaseObject {

	Business business;
	
	List attributeInsts = new ArrayList();

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public List getAttributeInsts() {
		return attributeInsts;
	}

	public void setAttributeInsts(List attributeInsts) {
		this.attributeInsts = attributeInsts;
	}
	
	public void addAttributeInst(AttributeInst attributeInst){
		this.attributeInsts.add(attributeInst);
	}
	
	public AttributeInst getAttributeInst(String name){
		AttributeInst attributeInst = null;
		for(int i=0;i<attributeInsts.size();i++){
			AttributeInst attrInst = (AttributeInst)attributeInsts.get(i);
			if(attrInst.getAttribute().getName().equalsIgnoreCase(name)){
				attributeInst = attrInst;
				break;
			}
		}
		return attributeInst ;
	}
}
