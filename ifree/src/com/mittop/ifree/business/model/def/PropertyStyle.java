package com.mittop.ifree.business.model.def;

import javax.xml.bind.annotation.XmlAttribute;

import com.mittop.ifree.base.model.BaseObject;

public abstract class PropertyStyle  extends Property{
	
	public boolean isVisiable() {
		return visiable;
	}

	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}

	@XmlAttribute
	private boolean visiable;
	
}
