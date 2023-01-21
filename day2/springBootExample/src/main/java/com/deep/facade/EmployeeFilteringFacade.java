package com.deep.facade;

import java.math.BigDecimal;
import java.util.List;
import com.deep.Employee;

public interface EmployeeFilteringFacade {
	void day3();

	List<Employee> getAllEmp();

	List<Employee> getEmpById(BigDecimal empId);
	
	Employee addEmp(Employee employee);

	List<Employee> delEmp(BigDecimal empId);

	void updateEmp(String empId, Employee employee);

}
