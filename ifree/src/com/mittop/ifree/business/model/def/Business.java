package com.mittop.ifree.business.model.def;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

import com.mittop.ifree.base.model.BaseObject;

@Entity

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "business_sequence")
public class Business extends BaseObject {

	public Business() {
	}

	Category category;

	Business parent;

	@Transient
	public Business getParent() {
		return parent;
	}

	public void setParent(Business parent) {
		this.parent = parent;
	}

	@XmlAttribute
	private String tableName;
	@XmlAttribute
	private String cnName;
	@XmlElement
	private String sqlList;
	@XmlElement
	private String sqlEdit;
	@XmlElementWrapper(name = "forms")
	@XmlElement(name = "form")
	private java.util.List<Form> forms = new ArrayList<Form>();
	@XmlElementWrapper(name = "lists")
	@XmlElement(name = "list")
	private java.util.List<List> lists = new ArrayList<List>();

	@XmlElementWrapper(name = "businesses")
	@XmlElement(name = "business")
	private java.util.List<Business> businesses = new ArrayList<Business>();

	@Transient
	public java.util.List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(java.util.List<Business> businesses) {
		this.businesses = businesses;
		for (int i = 0; i < this.businesses.size(); i++) {
			this.businesses.get(i).setParent(this);
		}
	}

	public void setForms(java.util.List<Form> forms) {
		this.forms = forms;
	}

	public void setLists(java.util.List<List> lists) {
		this.lists = lists;
	}

	public void setAttributes(java.util.List<Attribute> attributes) {
		this.attributes = attributes;
		for (int i = 0; i < this.attributes.size(); i++) {
			this.attributes.get(i).setBusiness(this);
		}
	}

	@Transient
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Transient
	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	@Transient
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	public String getSqlList() {
		return sqlList;
	}

	public void setSqlList(String sqlList) {
		this.sqlList = sqlList;
	}

	@Transient
	public String getSqlEdit() {
		return sqlEdit;
	}

	public void setSqlEdit(String sqlEdit) {
		this.sqlEdit = sqlEdit;
	}

	@XmlElementWrapper(name = "attributes")
	@XmlElement(name = "attribute")
	java.util.List<Attribute> attributes = new ArrayList<Attribute>();

	@Transient
	public java.util.List<Attribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(Attribute attribute) {
		this.attributes.add(attribute);
	}

	@Transient
	public java.util.List<List> getLists() {
		return lists;
	}

	@Transient
	public java.util.List<Form> getForms() {
		return forms;
	}

	public void addForm(Form form) {
		this.forms.add(form);
	}

	public void addList(List list) {
		this.lists.add(list);
	}

	@Transient
	public java.util.List<View> getViews() {
		java.util.List<View> views = new ArrayList();
		views.addAll(forms);
		views.addAll(lists);
		return views;

	}

	@Transient
	public Form getForm() {
		Form form = null;
		if (forms.size() > 0) {
			form = forms.get(0);
		}
		return form;
	}

	@Transient
	public Form getForm(String name) {
		Form form = null;
		if (name == null) {
			form = this.getForm();
		} else {
			for (int i = 0; i < forms.size(); i++) {
				if (name.equalsIgnoreCase(forms.get(i).getName())) {
					form = forms.get(i);
					break;
				}
			}
		}
		return form;
	}
//
//	@Lob
//	@Type(type="org.springframework.orm.hibernate3.support.ClobStringType")
//	@Column(name = "DEF", columnDefinition = "TEXT", nullable = true)
//	@Transient
	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	String def;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "sequenceGenerator")
	public Long getId() {
		return super.getId();
	}

	
	@Column
	public String getName() {
		return super.getName();
	}

}
