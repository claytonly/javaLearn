package com.zly.javaLearn.reflect;

public class Role {

	private String name;
	private String type;
	
	public Role(){
		System.out.println("Construct or Role() is invoking");
	}
	private Role(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}

}
