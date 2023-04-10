package com.naehas.assignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    //define the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "work_type")
    private String workType;

    @Column(name = "wage_before_tax")
    private double wageBeforeTax;

    @Column(name = "wage_after_tax")
    private double wageAfterTax;

    //define constructors

    public Employee(){}

    public Employee(String name, String workType, double wageBeforeTax) {
        this.name = name;
        this.workType = workType;
        this.wageBeforeTax = wageBeforeTax;
    }


    //define getter/setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWageBeforeTax() {
        return wageBeforeTax;
    }

    public void setWageBeforeTax(double wageBeforeTax) {
        this.wageBeforeTax = wageBeforeTax;
    }

    public double getWageAfterTax() {
        return wageAfterTax;
    }

    public void setWageAfterTax(double wageAfterTax) {
        this.wageAfterTax = wageAfterTax;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
    //define toString method

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wageBeforeTax=" + wageBeforeTax +
                ", wageAfterTax=" + wageAfterTax +
                '}';
    }
}
