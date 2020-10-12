package com.demo.ConStructorDI;

public class DisplayNameUsingConstructorDI {
	private String name;
	public DisplayNameUsingConstructorDI() {
		System.out.println("Bandi");
	}
	public DisplayNameUsingConstructorDI(String name) {
		this.name = name;
	}
	void sampleDemo() {
		System.out.println(name);
	}
}
