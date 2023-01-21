package com.deep.controller;

import com.deep.DTO.EmployeeDetailWsDTO;
import com.deep.DTO.EmployeeResponseWsDTO;
import com.deep.Employee;
import com.deep.facade.EmployeeFilteringFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepak Kumar Thakur
 */
@RestController
public class ControllerHome {

    @Autowired
    private EmployeeFilteringFacade eff;

    /**
     * Handles the home page for the application
     */
    @GetMapping("/home")
    public String home() {
        eff.day3();
        return String.format("Welcome buddies!!!");
    }

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
    public EmployeeResponseWsDTO getEmp(@RequestParam(name = "empId", defaultValue = "0") BigDecimal empId) {

        List<Employee> employee;
        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        try {
            if (empId.compareTo(BigDecimal.valueOf(0)) == 0) {
                employee = eff.getAllEmp();
            } else {
                employee = eff.getEmpById(empId);
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
    public EmployeeResponseWsDTO addEMp(@RequestBody Employee employee) {

        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();

        try {
            eff.addEmp(employee);
            populateEmployeeResponse(eff.getAllEmp(), response);
        } catch (Exception e) {

        }

        return response;
    }

//    /**
//     * Deletes employee based on Employee Id
//     */
//    @DeleteMapping("/employee")
//    public EmployeeResponseWsDTO delEmp(@RequestParam(name = "empId", defaultValue = " ") String empId) {
//        EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();
//
//        try {
//            eff.delEmp(empId);
//            response.setResponse(true);
//        } catch (Exception e) {
//            response.setResponse(false);
//        }
//
//        return response;
//    }

//	@PutMapping("/employee")
//	public EmployeeResponseWsDTO updateEmp(@RequestParam(name = "empId", defaultValue = " ") String empId,
//			@RequestBody Employee employee) {
//		EmployeeResponseWsDTO response = new EmployeeResponseWsDTO();
//
//		try {
//			eff.updateEmp(empId, employee);
//			response.setResponse(true);
//		} catch (Exception e) {
//			response.setResponse(false);
//		}
//
//		return response;
//	}

}