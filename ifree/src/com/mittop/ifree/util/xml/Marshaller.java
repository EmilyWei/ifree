package com.mittop.ifree.util.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.mittop.ifree.base.model.BaseObject;

public class Marshaller {

	BaseObject baseObject ;
	
	public Marshaller(BaseObject baseObject ) {
		this.baseObject = baseObject ;
	}
	
	public String marshall() throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(baseObject.getClass());
		javax.xml.bind.Marshaller marshaller= jaxbContext.createMarshaller();
		
		StringWriter stringWriter= new StringWriter();
		marshaller.marshal(baseObject, stringWriter);
		return stringWriter.toString();
	}
	
		


}
