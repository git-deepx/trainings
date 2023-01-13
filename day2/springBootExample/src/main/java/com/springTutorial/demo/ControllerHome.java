package com.springTutorial.demo;

import com.day3Task1.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHome {

	/*
	 * ControllerHome(String name, String id, Integer age, String nationality) {
	 * super(name, id, age, nationality); // TODO Auto-generated constructor stub }
	 */
	
	public void day3() {
		
		Addition add = new Addition();
		add.calculate(1, 2);
		
		Subtraction diff = new Subtraction();
		diff.calculate(1, 2);
		
		Multiplication prod = new Multiplication();
		prod.calculate(1, 2);
		
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Deep", "7000033080", 50, "Indian"));
		emp.add(new Employee("Shubham", "7000033789", 13, "Indian"));
		emp.add(new Employee("Nadeem", "7000033865", 22, "Indian"));
		emp.add(new Employee("Manisha", "7000033927", 22, "Indian"));
		
		
		System.out.println(emp.size());
		
		List<Employee> empStartingWithS = new ArrayList<>();
		empStartingWithS = emp.stream().filter(obj -> obj.getName().startsWith("S")).collect(Collectors.toList());
		System.out.println(empStartingWithS);
		
		List<String> empNames = new ArrayList<>();
		empNames = emp.stream().map(obj -> obj.getName()).collect(Collectors.toList());
		System.out.println(empNames);
		
		Map<String, String> empMap = emp.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(empMap);
		
		emp.add(new Employee("Manisha", "7000033927", 22, "Indian"));
		Set<String> empNamesSet = empNames.stream().collect(Collectors.toSet());
		System.out.println(empNamesSet);
		
		Map<Boolean, List<Employee>> empAsPerAge = emp.stream()
				.collect(Collectors.partitioningBy(obj -> obj.getAge() > 30));
		System.out.println(empAsPerAge);
		
		System.out.println(emp.stream().filter(obj -> obj.getName().startsWith("S") && obj.getAge() < 30)
				.collect(Collectors.toList()));
		
		List<Employee> sortedEmp = emp.stream().sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println(sortedEmp);
		
		System.out.println(emp.stream()
				.filter(obj -> ("Indian").equalsIgnoreCase(obj.getNationality()) && obj.getAge() > 30).count());
		
		String joinedEmp = empNames.stream().collect(Collectors.joining(", "));
		System.out.println(joinedEmp);
	}


	@RequestMapping("/")
	public String hello(@RequestParam(value = "day", defaultValue = "1") String day) {
		
		switch(day) {
			case "3": day3();
					break;
			default: return "none is executed";
		}
			
		return String.format("Executed Day: %s!", day);
	}
}
