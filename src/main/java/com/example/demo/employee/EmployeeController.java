package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Will have all the resources for our api - Api Layer
 */

@RestController
@RequestMapping(path = "api/v1/employee") 
public class EmployeeController {
    
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
 
    @PostMapping
    public void registerNewStudent(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }
    @DeleteMapping(path = "{employeeId}")
    public void deleteStudent(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    @PutMapping(path = "{employeeId}")
    public void updateStudent(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
            employeeService.updateEmployee(employeeId,name,email);
     }


}


