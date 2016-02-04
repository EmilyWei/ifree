package com.mittop.ifree.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 7674142848328216507L;
	
	
	
	@XmlAttribute
	private Long id;
	@XmlAttribute
	private String name;



	@Column
	public String getName() {
		return name;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "sequenceGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
