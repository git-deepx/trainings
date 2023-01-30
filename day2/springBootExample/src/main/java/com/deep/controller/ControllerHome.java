package com.deep.controller;

import com.deep.DTO.EmployeeDetailWsDTO;
import com.deep.DTO.EmployeeResponseWsDTO;
import com.deep.entity.Employee;
import com.deep.facade.EmployeeFilteringFacade;
import com.deep.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Deepak Kumar Thakur
 */

@RestController
public class ControllerHome {

    @Autowired
    private EmployeeFilteringFacade eff;

    @Autowired
    private EmployeeRepository repository;

    /**
     * Populates the employeeResponse
     */
    private void populateEmployeeResponse(List<Employee> employee,
                                          EmployeeResponseWsDTO response) {

        List<EmployeeDetailWsDTO> employees = new ArrayList<>();

        employee.forEach(emp -> {
            employees.add(new EmployeeDetailWsDTO(emp.getName(), emp.getId()));
        });
        response.setEmployees(employees);
    }

    /**
     * Returns Employees Data
     */
    @GetMapping("/employee")
    public EmployeeResponseWsDTO getEmp(@RequestParam(name = "empId", defaultValue = "0") Long empId) {

        List<Employee> employee;
        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        try {
            if (empId.compareTo(Long.valueOf(0)) == 0) {
                employee = eff.getAllEmp();
            } else {
                employee = eff.getEmpById(empId).stream().toList();
            }
            populateEmployeeResponse(employee, response);

        } catch (Exception e) {
        }

        return response;
    }

    /**
     * Insert new Employees to the list
     */
    @PostMapping(path = "/employee", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public EmployeeResponseWsDTO addEmp(@RequestBody Employee employee) {

        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        try {
            if (repository.findById(employee.getId()).isPresent()) {
                System.out.println("ID already exists");
            }
            else {
                eff.addEmp(employee);
            }
            populateEmployeeResponse(eff.getAllEmp(), response);
        }
        catch(Exception e) {
        }

        return response;
    }

    /**
     * Deletes employee based on Employee Id
     */
    @DeleteMapping("/employee")
    public EmployeeResponseWsDTO delEmp(@RequestParam(name = "empId", defaultValue = " ") Long empId) {

        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        try {
            eff.delEmp(empId);
            populateEmployeeResponse(eff.getAllEmp(), response);
        } catch (Exception e) {
            System.out.println("in exception");
        }

        return response;
    }

	@PutMapping("/employee")
	public EmployeeResponseWsDTO updateEmp(@RequestBody Employee employee) {
		EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        if (repository.findById(employee.getId()).isPresent()) {
            eff.addEmp(employee);
            populateEmployeeResponse(eff.getAllEmp(), response);
        }
        else {
            System.out.println("ID Not Found");
        }

		return response;
	}

}