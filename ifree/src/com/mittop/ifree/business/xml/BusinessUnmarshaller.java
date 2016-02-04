package com.mittop.ifree.business.xml;

import java.util.List;

import com.mittop.ifree.base.model.BaseObject;
import com.mittop.ifree.business.model.def.Attribute;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.def.Property;
import com.mittop.ifree.business.model.def.View;
import com.mittop.ifree.util.xml.Unmarshaller;

public class BusinessUnmarshaller extends Unmarshaller{

	public BusinessUnmarshaller(String xml) {
		super(xml);
	}



	public Business getBusiness() {
		return (Business)super.getBaseObject();
	}



	@Override
	public void buildRelation(BaseObject baseObject) {
		build((Business)baseObject);
	}

	
	private void build(Business business){
		java.util.List<View> views = business.getViews();
		for(int i=0;i<views.size();i++){
			View view = views.get(i);
			List<Property> propertyList = view.getPropertyList();
			for(int j=0;j<propertyList.size();j++){
				Property property = propertyList.get(j);
				Attribute attribute = getAttribute(business,property.getName());
				property.setAttribute(attribute );
			}
		}
	}

	private Attribute getAttribute(Business business, String name) {
		Attribute attribute = null;
		List<Attribute> attributes = business.getAttributes();
		for(int i=0;i<attributes.size();i++){
			if(attributes.get(i).getName().equalsIgnoreCase(name)){
				attribute = attributes.get(i);
				break;
			}
		}
		return attribute ;
	}


	@Override
	public Class getTargetClass() {
		return Business.class;
	}



}
