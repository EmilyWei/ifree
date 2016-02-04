package com.mittop.ifree.business.service.impl;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.mittop.ifree.IfreeException;
import com.mittop.ifree.base.service.BaseServiceTestCase;
import com.mittop.ifree.business.adaptor.XmlConvertor;
import com.mittop.ifree.business.controller.BusinessHelper;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;
import com.mittop.ifree.business.service.BusinessService;
import com.mittop.ifree.business.xml.BusinessUnmarshaller;
import com.mittop.ifree.util.xml.Marshaller;

public class BusinessServiceImplTestCase extends BaseServiceTestCase {

	@Resource(name = "businessService")
	private BusinessService businessService;

	
	

	@Test
	public void getBusinessByName() throws IfreeException {
		String name = "FEE_FEE_ITEM";
		this.businessService.getBusiness(name );
	}
	
	@Test
	public void makeBusiness() throws IfreeException {
		String tableName = "fawen";
		Business business = businessService.makeBusiness(tableName);

		Marshaller marshaller = new Marshaller(business);
		try {
			System.out.println(marshaller.marshall());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void makeSchema() {

		String xml = read("data/java/wu.xml");
		Business business = null;
		try {
			BusinessUnmarshaller businessUnmarshaller = new BusinessUnmarshaller(xml);
			businessUnmarshaller.parse();
			business = businessUnmarshaller.getBusiness();
			businessService.makeSchema(business);
		} catch (Exception e) {
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

	@Test
	public void importXml() {

		File dir = new File("D:\\project\\ifree\\test\\data\\net");

		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				try {
					FileInputStream fileInputStream = new FileInputStream(files[i]);

					XmlConvertor xmlConvertor = new XmlConvertor(fileInputStream);

					String xml = xmlConvertor.convert();

					FileOutputStream fos = new FileOutputStream(
							"D:\\project\\ifree\\test\\data\\java\\" + files[i].getName());
					fos.write(xml.getBytes());
					fos.flush();
					fos.close();

					System.out.println(xml);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		dir = new File("D:\\project\\ifree\\test\\data\\java");

		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				try {
					FileInputStream fileInputStream = new FileInputStream(files[i]);
					byte[] data = new byte[fileInputStream.available()];
					fileInputStream.read(data);
					String xml = new String(data);
					
					BusinessUnmarshaller businessUnmarshaller = new BusinessUnmarshaller(xml);

					businessUnmarshaller.parse();
					Business business = businessUnmarshaller.getBusiness();
					this.businessService.save(business);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
