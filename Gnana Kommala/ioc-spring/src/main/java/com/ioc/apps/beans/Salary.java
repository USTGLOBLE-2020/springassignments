package com.ioc.apps.beans;

import org.springframework.stereotype.Component;

@Component
public class Salary {
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
