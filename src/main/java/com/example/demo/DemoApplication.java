package com.example.demo;

import com.example.demo.employee.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@SpringBootApplication
public class DemoApplication {
	//@RestController makes this class serve rest endpoints
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
