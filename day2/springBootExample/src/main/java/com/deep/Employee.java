package com.deep;

import java.math.BigDecimal;

public class Employee {
	private String name;
	private BigDecimal id;
	private Integer age;
	private String nationality;

	public Employee(String name, BigDecimal id, Integer age, String nationality) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getId() {
		return id;
	}

	public Integer getAge() {
		return age;
	}

	public String getNationality() {
		return nationality;
	}

	@Override
	public String toString() {
		return name + " " + id + " " + age + " " + nationality; // anything you want to return, in this case all the
																// values in the class
	}

	public void something() {
		// TODO Auto-generated method stub
		System.out.println("do something");
	}

}
