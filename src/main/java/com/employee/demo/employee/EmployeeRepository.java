package com.employee.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("Select e From Employee e where e.email = ?1")
    Optional<Employee> findEmployeeByEmail(String email);
}
