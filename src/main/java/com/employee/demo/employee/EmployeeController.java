package com.employee.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Will have all the resources for our api - Api Layer
 * Communicates with ServiceLayer(Employee Service).
 */

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getStudents() {
        return employeeService.getEmployee();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }
    @DeleteMapping(path = "{employeeId}")

    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId){//take something from the path.
        employeeService.deleteEmployee(employeeId);
    }

    //Using Transactional we do not need to write/implement any JPQL
    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId,name,email);
    }

}
