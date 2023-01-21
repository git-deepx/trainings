package com.deep.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.deep.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFilteringServiceImpl implements EmployeeFilteringService {
	private List<Employee> emp = new ArrayList<>();

	public EmployeeFilteringServiceImpl() {
		super();
		System.out.println("in efs const");
	}

	@Override
	public void addData() {
		emp.add(new Employee("Deep", new BigDecimal("7000033080"), 50, "Indian"));
		emp.add(new Employee("Shubham", new BigDecimal("7000033092"), 13, "Indian"));
		emp.add(new Employee("Nadeem", new BigDecimal("7000033111"), 22, "Indian"));
		emp.add(new Employee("Manisha", new BigDecimal("7000031720"), 22, "Indian"));
	}

	@Override
	public void scenerio2() {

		List<Employee> empStartingWithS = new ArrayList<>();

		empStartingWithS = emp.stream().filter(obj -> obj.getName().startsWith("S")).collect(Collectors.toList());
		System.out.println(empStartingWithS);
	}

	@Override
	public void scenerio3() {
		List<String> empNames = new ArrayList<>();

		empNames = emp.stream().map(obj -> obj.getName()).collect(Collectors.toList());
		System.out.println(empNames);
	}

	@Override
	public void scenerio4() {
		Map<BigDecimal, String> empMap = emp.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));

		System.out.println(empMap);
	}

	@Override
	public void scenerio5() {
		List<String> empNames = emp.stream().map(obj -> obj.getName()).collect(Collectors.toList());
		emp.add(new Employee("Manisha", new BigDecimal("7000033927"), 22, "Indian"));

		Set<String> empNamesSet = empNames.stream().collect(Collectors.toSet());
		System.out.println(empNamesSet);
	}

	@Override
	public void scenerio6() {
		Map<Boolean, List<Employee>> empAsPerAge = emp.stream()
				.collect(Collectors.partitioningBy(obj -> obj.getAge() > 30));

		System.out.println(empAsPerAge);
	}

	@Override
	public void scenerio7() {
		System.out.println(emp.stream().filter(obj -> obj.getName().startsWith("S") && obj.getAge() < 30)
				.collect(Collectors.toList()));
	}

	@Override
	public void scenerio8() {
		List<Employee> sortedEmp = emp.stream().sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println(sortedEmp);
	}

	@Override
	public void scenerio9() {
		System.out.println(emp.stream()
				.filter(obj -> ("Indian").equalsIgnoreCase(obj.getNationality()) && obj.getAge() > 30).count());
	}

	@Override
	public void scenerio10() {

		List<String> empNames = emp.stream().map(obj -> obj.getName()).collect(Collectors.toList());

		String joinedEmp = empNames.stream().collect(Collectors.joining(", "));
		System.out.println(joinedEmp);
	}

	@Override
	public List<Employee> getAllEmp() {
		return emp;
	}

	@Override
	public Employee addEmp(Employee employee) {
		emp.add(employee);
		System.out.println("Employee Added");
		return employee;
	}

	@Override
	public List<Employee> delEmp(BigDecimal empId) {

		java.util.Iterator<Employee> itr = emp.iterator();

		while (itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e.getId() + "\n");
			if (e.getId().compareTo(empId) == 0) {
				itr.remove();
				return emp;
			}
		}

		System.out.println("Cannot Delete, Please Enter Vaild Employee ID");
		return emp;
	}

	@Override
	public List<Employee> getEmpById(BigDecimal empId) {
		List<Employee> employee = new ArrayList<>();

		for (Employee e : emp) {
			if (e.getId().compareTo(empId) == 0) {
				employee.add(e);
				return employee;
			}
		}

		return null;
	}

}
