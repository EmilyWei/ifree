package com.mittop.ifree.business.controller;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.mittop.ifree.business.model.def.Attribute;
import com.mittop.ifree.business.model.def.Business;
import com.mittop.ifree.business.model.def.Form;
import com.mittop.ifree.business.model.def.FormPropertyStyle;
import com.mittop.ifree.business.model.def.ListPropertyStyle;
import com.mittop.ifree.business.model.inst.BusinessInst;
import com.mittop.ifree.business.model.inst.FormContext;

import freemarker.template.Template;

public class BusinessHelper {

	public BusinessHelper() {
		// TODO Auto-generated constructor stub
	}

	public String getFormScriptlet(BusinessInst businessInst, FormContext formContext) {
		Business business = businessInst.getBusiness();
		String formName = formContext.getFormName();
		Form form = business.getForm(formName);
		return form.getScriptlet();
	}

	public String getLayout(BusinessInst businessInst, FormContext formContext) {
		Business business = businessInst.getBusiness();
		String formName = formContext.getFormName();
		Form form = business.getForm(formName);
		String layout = form.getEditLayout();
		Map map = this.buildMap(businessInst, form);
		return this.buildFormLayout(business.getName(),layout, map);
	}

	private Map buildMap(BusinessInst businessInst, Form form) {
		Map map = new HashMap();
		Map attrMap = new HashMap();
		Business business = businessInst.getBusiness();

		List<FormPropertyStyle> formPropertyStyles = form.getFormPropertyStyles();

		if (formPropertyStyles.size() > 0) {
			this.buildAttribiteInstHtml(formPropertyStyles, businessInst, attrMap);
		} else {
			this.buildAttribiteHtml(business.getAttributes(), businessInst, attrMap);
		}

		map.put(business.getTableName(), attrMap);
		
		
		if(business.getBusinesses().size()>0){
			List<Attribute> attributes = business.getBusinesses().get(0).getAttributes();
			for(int i=0;i<attributes.size();i++){
				 Attribute attribute =  attributes.get(i);
				 map.put(attribute.getName(), attribute.getCnName());
			}
		}

		return map;
	}

	private void buildAttribiteHtml(List<Attribute> attributes, BusinessInst businessInst, Map attrMap) {
		for (int i = 0; i < attributes.size(); i++) {

			Attribute attribute = attributes.get(i);
			attrMap.put(attribute.getName(), this.buildAttribiteInstHtml(attribute, businessInst));
		}
	}

	private void buildAttribiteInstHtml(List<FormPropertyStyle> formPropertyStyles, BusinessInst businessInst,
			Map attrMap) {
		for (int i = 0; i < formPropertyStyles.size(); i++) {

			FormPropertyStyle formPropertyStyle = formPropertyStyles.get(i);
			attrMap.put(formPropertyStyle.getAttribute().getName(),
					this.buildAttribiteInstHtml(formPropertyStyle, businessInst));
		}
	}

	private String buildAttribiteInstHtml(Attribute attribute, BusinessInst businessInst) {
		Business business = businessInst.getBusiness();
		return this.buildAttribiteInstHtml(business.getTableName(), attribute.getName(), true,
				attribute.getOrder(),
				businessInst.getAttributeInst(attribute.getName()).getValue());
	}

	private String buildAttribiteInstHtml(FormPropertyStyle formPropertyStyle, BusinessInst businessInst) {
		Attribute attribute = formPropertyStyle.getAttribute();
		Business business = businessInst.getBusiness();
		return this.buildAttribiteInstHtml(business.getTableName(), attribute.getName(), formPropertyStyle.isEditable(),
				formPropertyStyle.getAttribute().getOrder(),
				businessInst.getAttributeInst(attribute.getName()).getValue());

	}

	private String buildAttribiteInstHtml(String businessName, String attributeName, boolean editable, int order,
			Object value) {
		String templateHtml = "<input class='TextBoxInChar ${attribte_fullname}'  ${attribte_readonly} type='text' name='${attribute_id}' id='${attribute_id}' maxlength='256' title='最多输入256个字符'  value='${attributeInst_value}'  />";
		Map attrMap = new HashMap();
		attrMap.put("attribte_fullname", businessName + "_" + attributeName);
		attrMap.put("attribte_readonly", editable ? "" : "readonly");
		attrMap.put("attribute_id", "input_" + order);
		attrMap.put("attributeInst_value", value);
		return this.processTemplateIntoString(businessName, templateHtml, attrMap);

	}

	private String buildFormLayout(String businessName,String layout, Map map) {
		return this.processTemplateIntoString(businessName, layout, map);
	}

	
	private String processTemplateIntoString(String name,String template, Map map) {
		String str = "";
		try {
			// 通过指定模板名获取FreeMarker模板实例
			Reader reader = new StringReader(template);
			Template tpl = new Template(name, reader);
			// FreeMarker通过Map传递动态数据
			str = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	String buildProperties(Business business) {

		JSONArray jsonArray = new JSONArray();
		String[] keys = { "display", "name", "width", "sortable", "align", "renderer" };
		Object[] args = { "序号", "rowindex", "30", "false", "center", "colIdex" };
		JSONObject jsonProperty = this.buildJSONProperty(keys, args);
		jsonArray.put(jsonProperty);

		java.util.List<com.mittop.ifree.business.model.def.List> lists = business.getLists();
		com.mittop.ifree.business.model.def.List list = lists.get(0);
		java.util.List<ListPropertyStyle> listPropertyStyles = list.getListPropertyStyles();

		for (int i = 0; i < listPropertyStyles.size(); i++) {
			ListPropertyStyle listPropertyStyle = listPropertyStyles.get(i);

			Object[] p = { listPropertyStyle.getAttribute().getCnName(), listPropertyStyle.getName(),
					listPropertyStyle.getWidth(), "false", listPropertyStyle.getAlign(),
					listPropertyStyle.getFnRender() };
			jsonProperty = this.buildJSONProperty(keys, p);
			jsonArray.put(jsonProperty);

		}

		return jsonArray.toString();

	}

	JSONObject buildJSONProperty(String[] keys, Object[] values) {
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < keys.length; i++) {
			try {
				jsonObject.put(keys[i], values[i]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonObject;
	}

	public String getSysModel(BusinessInst businessInst, FormContext formContext) {
		Business business = businessInst.getBusiness();
		String formName = formContext.getFormName();
		Form form = business.getForm(formName);

		JSONObject jsonObjectSysModel = new JSONObject();

		try {
			jsonObjectSysModel.put("tablename", business.getTableName());

			JSONArray jsonArray = new JSONArray();

			List<FormPropertyStyle> formPropertyStyles = form.getFormPropertyStyles();
			String[] keys = { "name", "type", "length", "order", "empty", "namecn", "dispstyle", "limit" };
			for (int i = 0; i < formPropertyStyles.size(); i++) {
				FormPropertyStyle formPropertyStyle = formPropertyStyles.get(i);
				Object[] p = { formPropertyStyle.getAttribute().getName(), formPropertyStyle.getAttribute().getType(),
						formPropertyStyle.getAttribute().getLength(), formPropertyStyle.getAttribute().getOrder(), "0",
						formPropertyStyle.getAttribute().getCnName(), "", "" };
				JSONObject jsonObjectField = this.buildJSONProperty(keys, p);

				jsonArray.put(jsonObjectField);
			}

			jsonObjectSysModel.put("fields", jsonArray);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObjectSysModel.toString();
	}

}
