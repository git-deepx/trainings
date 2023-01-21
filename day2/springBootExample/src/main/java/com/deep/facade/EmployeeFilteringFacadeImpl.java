package com.deep.facade;

import java.math.BigDecimal;
import java.util.List;
import com.deep.Employee;
import com.deep.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFilteringFacadeImpl implements EmployeeFilteringFacade {
	
	@Autowired
	private EmployeeFilteringService efs;
	
	public void day3() {

		System.out.println("in day3");
		efs.addData();
//		efs.scenerio1();
//		efs.scenerio2();
//		efs.scenerio3();
//		efs.scenerio4();
//		efs.scenerio5();
//		efs.scenerio6();
//		efs.scenerio7();
//		efs.scenerio8();
//		efs.scenerio9();
//		efs.scenerio10();

	}

	@Override
	public List<Employee> getAllEmp() {
		return efs.getAllEmp();
	}

	@Override
	public Employee addEmp(Employee employee) {
		return efs.addEmp(employee);
	}

	@Override
	public List<Employee> delEmp(BigDecimal empId) {
		return efs.delEmp(empId);
	}

	@Override
	public List<Employee> getEmpById(BigDecimal empId) {
		return efs.getEmpById(empId);
	}

	@Override
	public void updateEmp(String empId, Employee employee) {
		// TODO Auto-generated method stub
		
	}
}
