package com.mittop.ifree.business.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.util.xml.Marshaller;

public class BusinessParserTestCase {

	@Test
	public void test() {

		String xml = read("data/java/T_BC_WordSort.xml");
		Business business = null;
		try {
			BusinessUnmarshaller businessUnmarshaller = new BusinessUnmarshaller(xml);
			businessUnmarshaller.parse();
			business = businessUnmarshaller.getBusiness();
		} catch (Exception e) {
			e.printStackTrace();
		}



		Marshaller marshaller = new Marshaller (business);
		try {
			System.out.println(marshaller.marshall());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private String read(String name) {
		String xml = null;
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
		try {
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			xml = new String(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
	
	
	
	
	

}
