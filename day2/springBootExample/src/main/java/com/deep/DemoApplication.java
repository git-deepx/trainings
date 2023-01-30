package com.deep;

import com.deep.entity.Employee;
import com.deep.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@SpringBootApplication
//@RestController
@ComponentScan(basePackages = "com.deep")
public class DemoApplication {

    @Autowired
    EmployeeRepository repository;

    public static void main(String[] args) {
    	SpringApplication.run(DemoApplication.class, args);
        System.out.println("DemoApplication");
    }

//    @PostConstruct
//    public void forTesting() {
//        System.out.println(repository.findAll());
//        repository.save(new Employee(1L,"html", 67, "ttyl"));
//        repository.save(new Employee(2L, "jsp", 90, "jnl"));
//        repository.save(new Employee(null, "ruby", 26, "ikr"));
//        System.out.println(repository.findAll());
//
//        repository.deleteById(2L);
//        System.out.println(repository.findAll());
//    }
}