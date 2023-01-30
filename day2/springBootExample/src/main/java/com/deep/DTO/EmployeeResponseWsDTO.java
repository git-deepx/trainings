package com.deep.DTO;

import java.util.List;

public class EmployeeResponseWsDTO {

	List<EmployeeDetailWsDTO> employees;

	public List<EmployeeDetailWsDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDetailWsDTO> employees) {
		this.employees = employees;
	}


}
