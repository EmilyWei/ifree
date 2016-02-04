package com.mittop.ifree.business.model.def;

import com.mittop.ifree.base.model.BaseObject;

public abstract class View  extends BaseObject{

	
	
	public View() {
	}
	

	public abstract java.util.List getPropertyList() ;
	
	String scriptlet;

	public String getScriptlet() {
		return scriptlet;
	}


	public void setScriptlet(String scriptlet) {
		this.scriptlet = scriptlet;
	}

}
