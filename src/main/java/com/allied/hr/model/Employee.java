package com.allied.hr.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String employeeNo;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEmployment;
    private BigDecimal biweeklySalary;
    @JsonIgnoreProperties("employees")
    private Department department;

    public Employee(String employeeNo, String firstName, String lastName, LocalDate dateOfBirth,
                    LocalDate dateOfEmployment, BigDecimal biweeklySalary) {
        this.employeeNo = employeeNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
        this.biweeklySalary = biweeklySalary;
    }

    /** Full years employed as of today; never negative even for future start dates. */
    public int getYearsOfEmployment() {
        int years = Period.between(this.dateOfEmployment, LocalDate.now()).getYears();
        return Math.max(0, years);
    }

    // getters/setters
    public String getEmployeeNo() { return employeeNo; }
    public void setEmployeeNo(String employeeNo) { this.employeeNo = employeeNo; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public LocalDate getDateOfEmployment() { return dateOfEmployment; }
    public void setDateOfEmployment(LocalDate dateOfEmployment) { this.dateOfEmployment = dateOfEmployment; }
    public BigDecimal getBiweeklySalary() { return biweeklySalary; }
    public void setBiweeklySalary(BigDecimal biweeklySalary) { this.biweeklySalary = biweeklySalary; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
