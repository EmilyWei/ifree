package com.mittop.ifree.business.model.def;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlAccessorType(XmlAccessType.FIELD)
public class Form extends View{

	private static final long serialVersionUID = -7457042260898747028L;
	
	
	@XmlElementWrapper(name = "formPropertyEvents")  
    @XmlElement(name = "formPropertyEvent")
	private java.util.List<FormPropertyEvent> formPropertyEvents = new ArrayList<FormPropertyEvent>();
	
	public void setFormPropertyEvents(java.util.List<FormPropertyEvent> formPropertyEvents) {
		this.formPropertyEvents = formPropertyEvents;
	}

	public void setFormPropertyStyles(java.util.List<FormPropertyStyle> formPropertyStyles) {
		this.formPropertyStyles = formPropertyStyles;
	}

	@XmlElementWrapper(name = "formPropertyStyles")  
    @XmlElement(name = "formPropertyStyle")
	private java.util.List<FormPropertyStyle> formPropertyStyles = new ArrayList<FormPropertyStyle>();
	
	@XmlElement
	private String editLayout;
	
	@XmlElement
	private String printLayout;
	
	@XmlElement
	private String viewLayout;
	
	public java.util.List<FormPropertyStyle> getFormPropertyStyles() {
		return formPropertyStyles;
	}
	
	public java.util.List<FormPropertyEvent> getFormPropertyEvents() {
		return formPropertyEvents;
	}
	
	public Form() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getEditLayout() {
		return editLayout;
	}

	public void setEditLayout(String editLayout) {
		this.editLayout = editLayout;
	}

	public String getPrintLayout() {
		return printLayout;
	}

	public void setPrintLayout(String printLayout) {
		this.printLayout = printLayout;
	}

	public String getViewLayout() {
		return viewLayout;
	}

	public void setViewLayout(String viewLayout) {
		this.viewLayout = viewLayout;
	}

	@Override
	public List getPropertyList() {
		List propertyList = new ArrayList();
		propertyList.addAll(this.formPropertyEvents);
		propertyList.addAll(this.formPropertyStyles);
		return propertyList;
	}

	public void addFormPropertyStyle(FormPropertyStyle formPropertyStyle) {
		this.formPropertyStyles.add(formPropertyStyle);
	}
}
