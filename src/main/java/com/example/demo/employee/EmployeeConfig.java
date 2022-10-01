package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
                Employee Silo = new Employee(
                                2l,
                                "Silo",
                                LocalDate.of(2000,Month.APRIL, 5),
                                "silo@gmail.com"
                        );
            Employee Sara = new Employee(
                    2l,
                    "Sara",
                    LocalDate.of(2004,Month.APRIL, 4),
                    "sara@gmail.com"
            );
            repository.saveAll(
                    List.of(Silo,Sara)
            );
        };
    }
}
