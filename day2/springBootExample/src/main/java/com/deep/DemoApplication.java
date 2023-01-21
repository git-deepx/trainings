package com.deep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.deep")
public class DemoApplication {

    public static void main(String[] args) {
    	SpringApplication.run(DemoApplication.class, args);
    	System.out.println("in DemoApplication");
    }
}