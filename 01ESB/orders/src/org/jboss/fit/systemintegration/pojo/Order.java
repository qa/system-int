package org.jboss.fit.systemintegration.pojo;

public class Order {
	private Long id;
	public String color;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {		
		return "Order[id="+id+",color="+color+"]";
	}

}
