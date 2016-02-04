package com.mittop.ifree.business.model.inst;

import com.mittop.ifree.base.model.BaseObject;

public class FormContext  extends BaseObject {

	String businessName;
	
	String currentUserId;
	
	String businessInstId;
	
	String formName;
	

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getBusinessInstId() {
		return businessInstId;
	}

	public void setBusinessInstId(String businessInstId) {
		this.businessInstId = businessInstId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
