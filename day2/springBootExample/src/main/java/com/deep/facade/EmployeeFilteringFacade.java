package com.deep.facade;

import com.deep.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeFilteringFacade {

    List<Employee> getAllEmp();

    Optional<Employee> getEmpById(Long empId);

    Employee addEmp(Employee employee);

    List<Employee> delEmp(Long empId);

    void updateEmp(Employee employee);

}
