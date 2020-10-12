package com.demo.SetterDI;

public class SetterDI {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	void display() {
		System.out.println(id+" id of Setter DI with name as "+name);
	}
}
