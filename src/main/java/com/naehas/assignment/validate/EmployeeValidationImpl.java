package com.naehas.assignment.validate;

import com.naehas.assignment.customException.RequestNotValidException;
import com.naehas.assignment.entity.Employee;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EmployeeValidationImpl implements EmployeeValidation {

    /**
     * add a method take object of Employee class
     * check Name must have the least five letter and a space
     * return null
     */
    @Override
    public void nameCheck(Employee employee) {

            if(employee.getName().length() < 5 || !employee.getName().contains(" ")){
                try {
                    throw new RequestNotValidException("Name must have least five letter and a space.");
                } catch (RequestNotValidException e) {
                    throw new RuntimeException(e);
                }
            }

    }


    /**
     *
     * take workType entered by user as an argument
     * check workType lies in T,C F only
     * @return true if lies
     */
    boolean workType(String workType){
        if(workType.equals("T") || (workType.equals("C") || workType.equals("F"))) {
            return true;
        }
        return false;

    }

    /**
     *
     * take object of Employee class as parameter
     * check workType is valid or not
     * @return null
     */
    @Override
    public void workTypeCheck(Employee employee) {
        employee.setWorkType(employee.getWorkType().toUpperCase());
            if(employee.getWorkType().length() > 1 || !workType(employee.getWorkType())){
                try {
                    throw new RequestNotValidException("workType must be lies in [`T`,`C`,`F`]");
                } catch (RequestNotValidException e) {
                    throw new RuntimeException(e);
                }
            }

    }

    /**
     *
     * take object of Employee class as parameter
     * check entered employee id exist or not in database table
     * @return null
     */
    @Override
    public void idNotFoundCheck(Employee employee) {
        if(employee == null)
            try {
                throw new RequestNotValidException("Employee id not found: "+employee.getId());
            } catch (RequestNotValidException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * take List of Employee type as parameter
     * check list is empty or not
     * @return null
     */
    @Override
    public void listEmptyCheck(List<Employee> employeeList) {

        if(employeeList.isEmpty()){
            try {
                throw new RequestNotValidException("Table is empty.");
            } catch (RequestNotValidException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
