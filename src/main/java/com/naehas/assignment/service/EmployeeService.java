package com.naehas.assignment.service;

import com.naehas.assignment.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    List<Employee> aboveThanAmount(double theAmount);

    double findWageByRqst(double amount, int theId);




}
