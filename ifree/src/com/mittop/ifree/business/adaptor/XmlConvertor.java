package com.mittop.ifree.business.adaptor;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlConvertor {

	InputStream dotnetInputStream;

	public XmlConvertor(InputStream dotnetInputStream) {
		super();
		this.dotnetInputStream = dotnetInputStream;
	}

	public String convert() throws Exception {

		StringWriter stringWriter = new StringWriter ();
		
		Source xmlSource = new StreamSource(this.dotnetInputStream);
		Source xsltSource = new StreamSource(
				this.getClass().getClassLoader().getResourceAsStream("com/mittop/ifree/business/adaptor/business.xsl"));
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		trans.transform(xmlSource, new StreamResult(stringWriter));

		return stringWriter.toString();
	}
}
