package com.deep.service;

import com.deep.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeFilteringService {

    void addData();

    void scenerio2();

    void scenerio3();

    void scenerio4();

    void scenerio5();

    void scenerio6();

    void scenerio7();

    void scenerio8();

    void scenerio9();

    void scenerio10();

    List<Employee> getAllEmp();

    List<Employee> getEmpById(BigDecimal empId);

    List<Employee> delEmp(BigDecimal empId);

    Employee addEmp(Employee employee);

}
