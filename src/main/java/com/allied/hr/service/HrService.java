package com.allied.hr.service;

import com.allied.hr.model.Department;
import com.allied.hr.model.Employee;
import com.allied.hr.repository.InMemoryDataStore;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HrService {
    /** Departments sorted by total annual salary (desc). */
    public List<Department> getDepartmentsSortedBySalary() {
        return InMemoryDataStore.getAllDepartments().stream()
                .sorted(Comparator.comparing(Department::getTotalAnnualSalary).reversed())
                .collect(Collectors.toList());
    }

    /** Employees sorted by years of employment (desc) then last name (asc). */
    public List<Employee> getEmployeesSortedByExperienceAndName() {
        return InMemoryDataStore.getAllEmployees().stream()
                .sorted(
                    Comparator.comparingInt(Employee::getYearsOfEmployment).reversed()
                              .thenComparing(Employee::getLastName)
                )
                .collect(Collectors.toList());
    }
}
