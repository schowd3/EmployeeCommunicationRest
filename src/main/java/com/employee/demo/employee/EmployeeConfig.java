package com.employee.demo.employee;

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
            Employee Jacob = new Employee(
                    1l,
                    "Jacob",
                    LocalDate.of(2000, Month.APRIL, 5),
                    "jacob@gmail.com"
            );
            Employee Sara = new Employee(
                    2l,
                    "Sara",
                    LocalDate.of(2001,Month.APRIL, 4),
                    "sara@gmail.com"
            );
            repository.saveAll(
                    List.of(Jacob,Sara)
            );
        };
    }
}
