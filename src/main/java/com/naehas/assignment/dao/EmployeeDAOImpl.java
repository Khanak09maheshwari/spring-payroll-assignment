package com.naehas.assignment.dao;

import com.naehas.assignment.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    /**
     * create a field for entitymanager
     */
    private EntityManager entityManager;


    /**
     * define constructor for constructor injection to database
     */
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * to find list of all employees from database table
     * @return list of all employee
     */
    @Override
    public List<Employee> findAll() {
        //create the query

        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);

        //return the list of employees
        return query.getResultList();
    }

    /**
     * to find  employee from database table by entered id
     * @return employee of entered id
     */
    @Override
    public Employee findById(int theId) {
        //create the query to find employee by id
        Employee employee = entityManager.find(Employee.class,theId);

        //return employee
        return employee;
    }

    /**
     * to save new employee details in database table
     * @return saved employee
     */
    @Override
    public Employee save(Employee theEmployee) {

        //save employee
        Employee employee = entityManager.merge(theEmployee);

        //return the employee
        return employee;
    }

    /**
     * find the list of filtered employees based on condition
     * @return filtered employees
     */
    @Override
    public List<Employee> aboveThanAmount(double theAmount) {

        //create the query
        TypedQuery<Employee> query = entityManager.createQuery( "FROM Employee where wageBeforeTax >=" + theAmount,Employee.class);

        //return the list of employee having wage after tax greater than entered amount
        return query.getResultList();
    }



}
