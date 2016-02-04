package com.mittop.ifree.business.model.def;

import java.util.List;

import com.mittop.ifree.base.model.BaseObject;

public class Category  extends BaseObject{

	public Category() {
	}
	
	List categories;

	public List getCategories() {
		return categories;
	}

	public void setCategories(List categories) {
		this.categories = categories;
	}

}
