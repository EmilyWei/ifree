package ifree;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Template;



public class TestFreemarker {

	@Test
	public void test() throws Exception {
		String htmlText="";  
        try {  
            String layout = "${QINGJIA.ABC!'a'}QINGJIA.ABC";
			//通过指定模板名获取FreeMarker模板实例  
            Reader reader = new StringReader(layout);
			Template tpl= new Template("abc", reader);
            Map QINGJIA = new HashMap();
            Map map = new HashMap();
            map.put("ABC", "QINGJIA");
            QINGJIA.put("QINGJIA", map);
			//FreeMarker通过Map传递动态数据  
            htmlText=FreeMarkerTemplateUtils.processTemplateIntoString(tpl,QINGJIA);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  

		System.out.println(htmlText);
		
	}

}
