package day3Task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "day3Task2")
public class DemoApplication {

    public static void main(String[] args) {
    	SpringApplication.run(DemoApplication.class, args);
    	System.out.println("in DemoApplication");
    }
}