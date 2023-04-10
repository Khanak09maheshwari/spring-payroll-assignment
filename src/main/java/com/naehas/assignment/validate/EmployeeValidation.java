package com.naehas.assignment.validate;

import com.naehas.assignment.entity.Employee;

import java.util.List;

public interface EmployeeValidation {
    void nameCheck(Employee employee);

    void workTypeCheck(Employee employee);

    void idNotFoundCheck(Employee employee);

    void listEmptyCheck(List<Employee> employeeList);


}
