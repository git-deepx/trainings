package com.deep.facade;

import com.deep.DTO.EmployeeResponseWsDTO;
import com.deep.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeFilteringFacade {

    List<Employee> getAllEmp();

    Optional<Employee> getEmpById(Long empId);

    Employee addEmp(Employee employee);

    void delEmp(Long empId);

    void updateEmp(Employee employee);

    void populateEmployeeResponse(List<Employee> employee,
                                  EmployeeResponseWsDTO response);

}
