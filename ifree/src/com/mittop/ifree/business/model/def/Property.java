package com.mittop.ifree.business.model.def;

import com.mittop.ifree.base.model.BaseObject;

public class Property extends BaseObject{

	public Property() {
		// TODO Auto-generated constructor stub
	}
	
	Attribute attribute ;

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public String getName() {
		if(attribute != null){
			super.setName(attribute.getName());
		}
		return super.getName();
	}

}
