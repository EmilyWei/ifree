package ifree;

import static org.junit.Assert.*;

import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;



public class TestXslt {

	@Test
	public void test() throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		
        Source xslt = new StreamSource(new File("D:\\project\\ifree\\test\\ifree\\t.xslt"));
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource(new File("D:\\project\\ifree\\test\\data\\net\\qingjia.xml"));
        transformer.transform(text, new StreamResult(new File("D:\\project\\ifree\\test\\data\\java\\qingjia.xml")));

		
		
	}

}
