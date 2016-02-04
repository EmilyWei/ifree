package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.mittop.ifree.base.model.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class Attribute extends BaseObject{

	public Attribute() {
	}
	
	
	Business business ;
	
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}


	@XmlAttribute
	private String cnName;
	
	@XmlAttribute
	private int type;
	
	@XmlAttribute
	private int length;
	
	@XmlAttribute
	private int order = -1;
	

	
	public int getOrder() {
		if(order == -1){
//			order = this.business.attributes.indexOf(this);
		}
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}


	@XmlAttribute
	private boolean indexable;
	
	@XmlAttribute
	private String comments;
	
	
	public static final int TYPE_STRING = 0;
	
	public static final int TYPE_INT = 1;
	
	public static final int TYPE_DATE = 2;
	
	public static final int TYPE_BLOB = 3;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isIndexable() {
		return indexable;
	}

	public void setIndexable(boolean indexable) {
		this.indexable = indexable;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
