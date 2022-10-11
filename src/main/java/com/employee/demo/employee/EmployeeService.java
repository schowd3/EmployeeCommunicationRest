package com.employee.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Service Layer - Contains all the business logic.
 * Interacts with the data access layer -
 */
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    // for GET
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }


    public void addNewEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.
                findEmployeeByEmail(employee.getEmail());
        //same email cannot be used twice.
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) {
            throw new IllegalStateException(
                    "employee with id" + employeeId + " does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }
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
                    findEmployeeByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            employee.setEmail(email);
        }
    }
}
