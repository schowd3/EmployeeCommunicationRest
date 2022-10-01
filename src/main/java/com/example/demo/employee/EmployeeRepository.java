package com.example.demo.employee;

/**
 * Data Access Layer
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository // Generics because student id of type long
        extends JpaRepository<Employee, Long> {
    //Business Logic- Custom function to find user my email
    //Select * From employee Where email = ? or
    @Query("SELECT s FROM Employee s where s.email = ?1") //JPQL - Employee referes to student class
    Optional<Employee> findStudentByEmail(String email);
}
