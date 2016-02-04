package com.mittop.ifree.util.xml;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.mittop.ifree.base.model.BaseObject;

public abstract class Unmarshaller {
	
	public BaseObject getBaseObject() {
		return baseObject;
	}

	private String xml;
	
	private BaseObject baseObject;
	
	public Unmarshaller(String xml) {
		this.xml = xml;
	}
	
	public void parse() throws JAXBException {
		doParse();
		buildRelation(baseObject);
	}
	
	public void buildRelation(BaseObject baseObject) {
		
	}
	
	private void doParse() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(getTargetClass());
		javax.xml.bind.Unmarshaller um = jaxbContext.createUnmarshaller();
		baseObject = (BaseObject) um.unmarshal(new ByteArrayInputStream(xml.getBytes()));
	}

	public abstract Class getTargetClass();
}
