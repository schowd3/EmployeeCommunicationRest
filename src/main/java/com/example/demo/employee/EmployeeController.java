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
@RequestMapping(path = "api/v1/employee") //local hosting deer
public class EmployeeController {
    // want to use the method inside employeeService - talking to service layer
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;//  EmployeeService gets instantiated and injected to the constructor. - Autowired for rest

        //this.employeeService = employeeService;// doesnt work
        //this.employeeService = new EmployeeService();// does work but not good design, we should use DI instead
    }

    //getMapping very important
    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    //employee comes from client
    //post add new resource
    @PostMapping
    public void registerNewStudent(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }
    @DeleteMapping(path = "{employeeId}")
    public void deleteStudent(
            @PathVariable("employeeId") Long employeeId){//take something from the path.
        employeeService.deleteEmployee(employeeId);
    }
    //Using Transactional we do not need to write/implement any JPQL
    @PutMapping(path = "{employeeId}")
    public void updateStudent(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
            employeeService.updateEmployee(employeeId,name,email);
     }


}


