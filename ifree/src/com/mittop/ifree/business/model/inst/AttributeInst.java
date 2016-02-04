package com.mittop.ifree.business.model.inst;

import com.mittop.ifree.business.model.def.Attribute;

public class AttributeInst {

	Attribute attribute;
	
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public BusinessInst getBusinessInst() {
		return businessInst;
	}

	public void setBusinessInst(BusinessInst businessInst) {
		this.businessInst = businessInst;
	}

	BusinessInst businessInst;
	
	
	Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
