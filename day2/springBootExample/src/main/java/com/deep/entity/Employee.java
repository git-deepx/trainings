package com.deep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "nationality")
    private String nationality;

    public Employee() {
    }

    public Employee(Long id, String name, Integer age, String nationality) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
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
