package org.jboss.vut.systemintegration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DummyObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer number;
	
	public DummyObject(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

}
