package com.allied.hr.repository;

import com.allied.hr.model.Department;
import com.allied.hr.model.Employee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** In-memory seed data exactly as provided in the prompt. */
public class InMemoryDataStore {
    private static final List<Department> departments = new ArrayList<>();
    private static final List<Employee> employees = new ArrayList<>();

    static {
        // Departments
        Department sales       = new Department("31288741190182539912", "Sales");
        Department marketing   = new Department("29274582650152771644", "Marketing");
        Department engineering = new Department("29274599650152771609", "Engineering");

        // Employees
        Employee michael = new Employee("000-11-1234", "Michael", "Philips",
                LocalDate.of(1995, 12, 31), LocalDate.of(2021, 10, 15), new BigDecimal("2750.50"));
        Employee anna = new Employee("000-61-0987", "Anna", "Smith",
                LocalDate.of(1981, 9, 17), LocalDate.of(2022, 8, 21), new BigDecimal("2500.00"));
        Employee john = new Employee("000-99-1766", "John", "Hammonds",
                LocalDate.of(2001, 7, 15), LocalDate.of(2025, 1, 23), new BigDecimal("1560.75"));
        Employee barbara = new Employee("000-41-1768", "Barbara", "Jones",
                LocalDate.of(2000, 11, 18), LocalDate.of(2025, 3, 13), new BigDecimal("1650.55"));

        // Employee-Department links (per the table's Department IDs 1:Sales, 2:Marketing, 3:Engineering)
        john.setDepartment(sales);
        sales.addEmployee(john);

        anna.setDepartment(marketing);
        marketing.addEmployee(anna);

        barbara.setDepartment(marketing);
        marketing.addEmployee(barbara);

        michael.setDepartment(engineering);
        engineering.addEmployee(michael);

        // Heads of Department per the table (Sales → 000-61-0987, Marketing → null, Engineering → 000-11-1234)
        sales.setHeadOfDepartment(anna);
        marketing.setHeadOfDepartment(null);
        engineering.setHeadOfDepartment(michael);

        // Persist lists
        departments.add(sales);
        departments.add(marketing);
        departments.add(engineering);

        employees.add(michael);
        employees.add(anna);
        employees.add(john);
        employees.add(barbara);
    }

    public static List<Department> getAllDepartments() { return departments; }
    public static List<Employee> getAllEmployees() { return employees; }
}
