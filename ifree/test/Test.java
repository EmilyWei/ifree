import java.text.MessageFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	@org.junit.Test
	public void test() {
		StringBuffer sb = new StringBuffer();

		String template = "display: \'{0}\', name : '{1}', width : {2}, sortable : {3}, align: '{4}',renderer:{5}";
		Object[] args = {"序号","rowindex","30","false","center","colIdex"};
		sb.append("{"+MessageFormat.format(template,args)+"}");

		
		
		System.out.println(sb.toString());
	}
	
	
	@org.junit.Test
	public void testJson() throws JSONException{
		JSONObject json=new JSONObject();
		JSONArray jsonMembers = new JSONArray();  
	    JSONObject member1 = new JSONObject();  
	    member1.put("loginname", "zhangfan");  
	    member1.put("password", "userpass");  
	    member1.put("email","10371443@qq.com");  
	    member1.put("sign_date", "2007-06-12");  
	    jsonMembers.put(member1);  
	  
	    JSONObject member2 = new JSONObject();  
	    member2.put("loginname", "zf");  
	    member2.put("password", "userpass");  
	    member2.put("email","8223939@qq.com");  
	    member2.put("sign_date", "2008-07-16");  
	    jsonMembers.put(member2);  
	    json.put("users", jsonMembers);
	    System.out.println(json.toString());
	}

}
