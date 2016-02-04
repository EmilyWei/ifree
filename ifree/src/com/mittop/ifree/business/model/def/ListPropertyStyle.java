package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListPropertyStyle extends PropertyStyle {

	private static final long serialVersionUID = -5697804687613335063L;

	public ListPropertyStyle() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	private boolean conditionable;

	@XmlElement
	private PropertyCondition propertyCondition;

	
	
	
	

	@XmlAttribute
	private int align;
	
	@XmlAttribute
	private int width;

	
	@XmlAttribute
	private String fnRender;
	
	@XmlAttribute
	private String pattern;
	
	@XmlAttribute
	private String statics;
	
	
	
	
	
	public PropertyCondition getPropertyCondition() {
		return propertyCondition;
	}

	public void setPropertyCondition(PropertyCondition propertyCondition) {
		this.propertyCondition = propertyCondition;
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getFnRender() {
		return fnRender;
	}

	public void setFnRender(String fnRender) {
		this.fnRender = fnRender;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getStatics() {
		return statics;
	}

	public void setStatics(String statics) {
		this.statics = statics;
	}

	public boolean isConditionable() {
		return conditionable;
	}

	public void setConditionable(boolean conditionable) {
		this.conditionable = conditionable;
	}
	
	
	
}
