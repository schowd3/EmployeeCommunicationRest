package com.employee.demo.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * Employee Object with all the attributes.
 * POJO class
 */

@Entity
@Table
public class Employee {
    //Sequence generator to auto-increment employee id.
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;

    public Employee() {
    }

    public Employee(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
    //DATABASE WILL GENERATE ID
    public Employee(String name,  LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer afe) {
        this.age = afe;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dov) {
        this.dob = dov;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
