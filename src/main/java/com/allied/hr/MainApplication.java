package com.allied.hr;

import com.allied.hr.model.Department;
import com.allied.hr.model.Employee;
import com.allied.hr.service.HrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        HrService hrService = new HrService();

        ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println("\n----- Departments Report (Sorted by Total Annual Salary Desc) -----\n");
        try {
            List<Department> departments = hrService.getDepartmentsSortedBySalary();
            System.out.println(mapper.writeValueAsString(departments));
        } catch (JsonProcessingException e) {
            System.err.println("Error processing Department JSON: " + e.getMessage());
        }

        System.out.println("\n----- Employees Report (Sorted by Years of Employment Desc, then Last Name Asc) -----\n");
        try {
            List<Employee> employees = hrService.getEmployeesSortedByExperienceAndName();
            System.out.println(mapper.writeValueAsString(employees));
        } catch (JsonProcessingException e) {
            System.err.println("Error processing Employee JSON: " + e.getMessage());
        }
    }
}
