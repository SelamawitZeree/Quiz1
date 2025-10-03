# Allied HR CLI (Task B)

This project implements the exact two JSON reports requested in the prompt.

## Build
```bash
mvn clean package
```

## Run (fat jar built via Maven Shade)
```bash
java -jar target/hr-app-1.0-SNAPSHOT.jar
```

Outputs:
1. Departments report (sorted by total annual salary desc), including employees, headOfDepartment, and `totalAnnualSalary`.
2. Employees report (sorted by years of employment desc, then last name asc), including each employee's `department`.
