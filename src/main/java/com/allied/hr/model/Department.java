package com.allied.hr.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private BigInteger departmentNo;     // very large numeric id → keep as String to preserve value exactly
    private String name;
    @JsonIgnoreProperties("department")
    private Employee headOfDepartment;
    @JsonIgnoreProperties("department")
    private List<Employee> employees = new ArrayList<>();

    public Department(BigInteger departmentNo, String name) {
        this.departmentNo = departmentNo;
        this.name = name;
    }

    public BigDecimal getTotalAnnualSalary() {
        return employees.stream()
                .map(Employee::getBiweeklySalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal("26")); // 26 biweekly periods per year
    }

    // getters/setters
    public BigInteger getDepartmentNo() { return departmentNo; }
    public void setDepartmentNo(BigInteger departmentNo) { this.departmentNo = departmentNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Employee getHeadOfDepartment() { return headOfDepartment; }
    public void setHeadOfDepartment(Employee headOfDepartment) { this.headOfDepartment = headOfDepartment; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
    public void addEmployee(Employee employee) { this.employees.add(employee); }
}
