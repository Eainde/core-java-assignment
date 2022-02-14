package com.eainde.assignment;

import com.eainde.assignment.entity.Employee;
import com.eainde.assignment.utility.FileUtil;

import java.io.IOException;
import java.util.List;

public class EmployeeService {

    public List<Employee> getEmployees() throws IOException {
        FileUtil util= new FileUtil();
        List<String> employeeListInString=util.getFile();

        // TODO write a code to get the list of employees from employeeListInString
        // Employee should be in the same order as in the csv file
        // Don't use any plugin like opencsv
        return null;
    }

    public List<Employee> sortedEmployees(){
        // TODO Sort an Employee Object list first by salary and if salaries are equal, then by name
        return null;
    }

    public Employee getEmployeeById(long id){
        // TODO write a code to get the employee by id
        return null;
    }

    public Employee getHighestSalaryEmployee(){
        // TODO write a code to get the employee who has highest salary
        return null;
    }

    public int getAverageSalary(){
        // TODO write a code to get the average salary of employees
        return 0;
    }

    public List<Employee> getEmployeesByCity(String city){
        // TODO write a code to get the employees by city. If there are two employees for one city then they should be sorted by employee name
        // Note: use HashMap
        return null;
    }
}
