package com.deep.service;

import com.deep.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeFilteringService {

    List<Employee> getAllEmp();

    Optional<Employee> getEmpById(Long empId);

    void delEmp(Long empId);

    Employee addEmp(Employee employee);

    void updateEmp(Employee employee);
}
