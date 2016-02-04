package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import com.mittop.ifree.base.model.BaseObject;

@XmlAccessorType(XmlAccessType.FIELD)
public class PropertyCondition extends BaseObject{

	public PropertyCondition() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlAttribute
	private int patternType;
	
	@XmlAttribute
	private int defaultValueType;
	
	@XmlAttribute
	private String defaultValue;

	public int getPatternType() {
		return patternType;
	}

	public void setPatternType(int patternType) {
		this.patternType = patternType;
	}

	public int getDefaultValueType() {
		return defaultValueType;
	}

	public void setDefaultValueType(int defaultValueType) {
		this.defaultValueType = defaultValueType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
