package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mittop.ifree.base.model.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class FormPropertyEvent extends PropertyEvent {

	private Attribute attribute ;

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public FormPropertyEvent() {
	}
	
	
	@XmlAttribute
	private String event;
	@XmlElement
	private String action;
	
	
	

	
	
	

	public String getName() {
		if(attribute != null){
			super.setName(attribute.getName());
		}
		return super.getName();
	}


}
