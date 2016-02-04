package com.mittop.ifree.business.adaptor;

public class Function {

	public static String doLayout(String layout){
		
		int index = layout.indexOf("</style>");
		
		
		if(index>0){
			String css = layout.substring(0, index+8);
			
			String html = layout.substring(index+8);
			
			html = html.replaceAll("\\{", "\\$\\{");
			
			
			
			return css+html;
		}else{
			return layout.replaceAll("\\{", "\\$\\{");
		}
		
		
	}
}
