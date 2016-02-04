package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class FormPropertyStyle extends PropertyStyle {

	private static final long serialVersionUID = 59144792564011561L;

	public FormPropertyStyle() {
		// TODO Auto-generated constructor stub
	}


	
	@XmlAttribute
	private boolean visiable;
	
	
	public boolean isVisiable() {
		return visiable;
	}

	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}



	@XmlAttribute
	private boolean editable;
	
	@XmlAttribute
	private boolean required;
	
	@XmlAttribute
	private int width;
	
	@XmlAttribute
	private int length;
	
	

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	

	

}
