package com.mittop.ifree.business.adaptor;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

public class XmlConvertorTestCase {

	@Test
	public void test() {
		
		File dir = new File("D:\\project\\ifree\\test\\data\\net");
		
		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			for(int i=0;i<files.length;i++){
				try {
					FileInputStream fileInputStream = new FileInputStream (files[i]);
					
					XmlConvertor xmlConvertor = new XmlConvertor(fileInputStream);
					
					
					String xml = xmlConvertor.convert();
					
					FileOutputStream fos =  new FileOutputStream ("D:\\project\\ifree\\test\\data\\java\\"+files[i].getName());
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
		
		fail("Not yet implemented");
	}
	
	

}
