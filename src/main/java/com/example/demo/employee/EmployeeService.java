package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Service Layer - Contains all the business logic.
 */

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        //dependency injenction
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        //adding feature to find a employee by email.
        Optional<Employee> studentOptional = employeeRepository
                .findStudentByEmail(employee.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        //simple
        employeeRepository.save(employee);
        //System.out.println(employee);
    }

    /**
     * Deletes the employee based on id.
     * @param employeeId
     */
    public void deleteEmployee(Long employeeId) {
       boolean exists = employeeRepository.existsById(employeeId);
       if(!exists) {
           throw new IllegalStateException(
                   "employee with id" + employeeId + " does not exists");
       }
       employeeRepository.deleteById(employeeId);
    }
    //Note: using Transactional because we do not need to write/implement any JPQL
    @Transactional
    public void updateEmployee(Long employeeId, String name, String email) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId +"does not exist"
                ));
        if(name != null
                &&
                name.length() > 0 &&
                !Objects.equals(employee.getName(),name)){
                employee.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(employee.getEmail(), email)) {
                Optional<Employee> studentOptional = employeeRepository.
                        findStudentByEmail(email);
                if(studentOptional.isPresent()){
                    throw new IllegalStateException("email taken");
                }
                employee.setEmail(email);
        }
    }
}
