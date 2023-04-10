package com.naehas.assignment.controller;

import com.naehas.assignment.entity.Employee;
import com.naehas.assignment.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    /**
     * create field for employeeService
     */
    private EmployeeService employeeService;

    /**
     * setup constructor for constructor injection
     */

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * expose an endpoint GET/employees --retrieve all employees
     * Show list of all employees with type of employee
     */
    @GetMapping("/employees")
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    /**
     * add mapping for GET/employees{employeeId} -retrieve employee by id
     * Show employee data with payroll for requested employee ID.
     */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        return theEmployee;

    }

    /**
     * add mapping for POST/employees -add new employee
     * Register an input amount as payroll from the user for requested employee ID.
     * calculate and save the taxed amount in the table.Save the amount in dollars. In the database.
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item... instead of update

        theEmployee.setId(0);

        Employee employee = employeeService.save(theEmployee);

        return employee;
    }

    /**
     * Take input from the user as an amount and return the filtered list of employees with higher than the input amount.
     */
    @GetMapping("/employees/amount")
    public ResponseEntity<List<Employee>>findAllByRsql(@RequestParam double amount){

        return new ResponseEntity<List<Employee>>(employeeService.aboveThanAmount(amount), HttpStatus.OK);
    }

    /**
     * Take input form the user as dollar or rupee and employee id
     * returns the taxed and non-taxed income of the employee in dollar or rupee (user conversion 1$=80Rs)
     */
    @GetMapping("/employees/wageamount/{employeeId}")
    public double wageCustomAmount(@PathVariable int employeeId , @RequestParam double amount){

        return employeeService.findWageByRqst(amount,employeeId);
    }



}
