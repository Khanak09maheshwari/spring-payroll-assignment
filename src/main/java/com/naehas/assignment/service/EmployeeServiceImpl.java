package com.naehas.assignment.service;

import com.naehas.assignment.dao.EmployeeDAO;
import com.naehas.assignment.entity.Employee;
import com.naehas.assignment.validate.EmployeeValidation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    /**
     * create fields for EmployeeDAO and EmployeeValidation class
     */
    //create field for EmployeeDAO
    private EmployeeDAO employeeDAO;
    private EmployeeValidation employeeValidation;

    /**
     *define constructor to inject constructor injection to controller
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, EmployeeValidation employeeValidation) {
        this.employeeDAO = employeeDAO;
        this.employeeValidation = employeeValidation;
    }

    /**
     * method to find list of all employees
     * validate list is empty or not
     * @return all employee list
     */
    @Override
    public List<Employee> findAll() {

        List<Employee> employeeList = employeeDAO.findAll();

        employeeValidation.listEmptyCheck(employeeList);

        //return the list of employee
        return employeeDAO.findAll();
    }

    /**
     * take parameter of integer type
     * find employee of entered id
     * validate employee of entered id is present or not in database table
     * @return employee of entered id
     */
    @Override
    public Employee findById(int theId) {
        Employee employee = employeeDAO.findById(theId);

        employeeValidation.idNotFoundCheck(employee);

        return employee;
    }

    /**
     * take object of Employee class as an argument
     * save new employee
     * validate all request entries
     * calculate the wage after tax
     * @return saved employee
     */
    @Override
    @Transactional
    public Employee save(Employee theEmployee) {

        //apply validations
        employeeValidation.nameCheck(theEmployee);
        employeeValidation.workTypeCheck(theEmployee);
        theEmployee.setWageAfterTax(calcSalary(theEmployee));

        return employeeDAO.save(theEmployee);
    }

    /**
     * take a parameter of double type
     * find the list of all employee whose wage before tax is greater than entered amount
     * @return list of filtered employee
     */
    @Override
    public List<Employee> aboveThanAmount(double theAmount) {
        return employeeDAO.aboveThanAmount(theAmount);
    }

    /**
     * take two parameters one double type and another one of integer type
     * find the wageAfter tax of employee according to entered id and amount
     * validate entered id is present or not
     * @return wageAfterTax
     */
    @Override
    public double findWageByRqst(double amount, int theId) {
        Employee employee = employeeDAO.findById(theId);
        employeeValidation.idNotFoundCheck(employee);
        double wageAfter = calcSalaryForCustomInput(employee,amount);

        return wageAfter;
    }

    /**
     * take object of Employee class as an argument
     * calculate the wage after tax according to employee work Type
     * @return wage after tax
     */

    public double calcSalary(Employee employee) {

        if(employee.getWorkType().equals("T")){
            return employee.getWageBeforeTax()-(employee.getWageBeforeTax()*15)/100;//return wage after deduct 15% Tax
        }
        if (employee.getWorkType().equals("C")) {
            return employee.getWageBeforeTax()-(employee.getWageBeforeTax()*18)/100;//return wage after deduct 18% Tax
        }

        return employee.getWageBeforeTax()-(employee.getWageBeforeTax()*30)/100;//return wage after deduct 30% (20% Tax + 10% benefits)

    }

    /**
     * take two parameters one object of employee class and another one of double type
     * @param employee
     * @param amount
     * @return
     */

    public double calcSalaryForCustomInput(Employee employee, double amount) {

        if(employee.getWorkType().equals("T")){
            return amount-(amount*15)/100;//return wage after deduct 15% Tax
        }
        if (employee.getWorkType().equals("C")) {
            return amount-(amount*18)/100;//return wage after deduct 18% Tax
        }

        return amount-(amount*30)/100;//return wage after deduct 30% (20% Tax + 10% benefits)

    }
}
