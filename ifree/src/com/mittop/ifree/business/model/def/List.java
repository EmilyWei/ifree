package com.mittop.ifree.business.model.def;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class List extends View{

	private static final long serialVersionUID = -7314184049005373002L;
	
	
	@XmlElementWrapper(name = "listPropertyStyles")  
    @XmlElement(name = "listPropertyStyle")
	private java.util.List<ListPropertyStyle> listPropertyStyles = new ArrayList<ListPropertyStyle>();

	public java.util.List<ListPropertyStyle> getListPropertyStyles() {
		return listPropertyStyles;
	}
	
	public void setListPropertyStyles(java.util.List<ListPropertyStyle> listPropertyStyles) {
		this.listPropertyStyles = listPropertyStyles;
	}


	public List() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public java.util.List getPropertyList() {
		java.util.List propertyList = new ArrayList();
		propertyList.addAll(this.listPropertyStyles);
		return propertyList;
	}

	public void addListPropertyStyle(ListPropertyStyle listPropertyStyle) {
		this.listPropertyStyles.add(listPropertyStyle);
	}

}
