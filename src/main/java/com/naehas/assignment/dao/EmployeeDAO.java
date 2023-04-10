package com.naehas.assignment.dao;

import com.naehas.assignment.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO  {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    List<Employee> aboveThanAmount(double theAmount);



}
