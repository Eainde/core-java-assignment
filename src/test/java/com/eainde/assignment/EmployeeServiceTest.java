package com.eainde.assignment;

import com.eainde.assignment.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class EmployeeServiceTest {

    @Test
    @DisplayName("Checking if the employees are in same order as they are in csv file")
    void getEmployees() {
        List<Employee> list = getInstance().getEmployees();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.get(0).getId(), 1);
        Assertions.assertEquals(list.get(0).getName(), "John");

        Assertions.assertEquals(list.get(1).getId(), 2);
        Assertions.assertEquals(list.get(1).getName(), "Dave");

        Assertions.assertEquals(list.get(2).getId(), 3);
        Assertions.assertEquals(list.get(2).getName(), "Amit");

        Assertions.assertEquals(list.get(3).getId(), 4);
        Assertions.assertEquals(list.get(3).getName(), "William");

        Assertions.assertEquals(list.get(4).getId(), 5);
        Assertions.assertEquals(list.get(4).getName(), "Tony");

        Assertions.assertEquals(list.get(5).getId(), 6);
        Assertions.assertEquals(list.get(5).getName(), "Anders");

        Assertions.assertEquals(list.get(6).getId(), 7);
        Assertions.assertEquals(list.get(6).getName(), "Archie");

        Assertions.assertEquals(list.get(7).getId(), 8);
        Assertions.assertEquals(list.get(7).getName(), "Brad");

        Assertions.assertEquals(list.get(8).getId(), 9);
        Assertions.assertEquals(list.get(8).getName(), "Kacper");

        Assertions.assertEquals(list.get(9).getId(), 10);
        Assertions.assertEquals(list.get(9).getName(), "Ben");
    }

    @Test
    @DisplayName("Checking if the employees are sorted by salary and name")
    void sortedEmployees() {
        List<Employee> list = getInstance().sortedEmployees();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.get(0).getId(), 4);
        Assertions.assertEquals(list.get(0).getName(), "William");
        Assertions.assertEquals(list.get(0).getSalary(), 90000);

        Assertions.assertEquals(list.get(1).getId(), 9);
        Assertions.assertEquals(list.get(1).getName(), "Kacper");
        Assertions.assertEquals(list.get(1).getSalary(), 80000);

        Assertions.assertEquals(list.get(2).getId(), 3);
        Assertions.assertEquals(list.get(2).getName(), "Amit");
        Assertions.assertEquals(list.get(2).getSalary(), 50000);

        Assertions.assertEquals(list.get(3).getId(), 8);
        Assertions.assertEquals(list.get(3).getName(), "Brad");
        Assertions.assertEquals(list.get(3).getSalary(), 50000);

        Assertions.assertEquals(list.get(4).getId(), 10);
        Assertions.assertEquals(list.get(4).getName(), "Ben");
        Assertions.assertEquals(list.get(4).getSalary(), 40000);

        Assertions.assertEquals(list.get(5).getId(), 1);
        Assertions.assertEquals(list.get(5).getName(), "John");
        Assertions.assertEquals(list.get(5).getSalary(), 40000);

        Assertions.assertEquals(list.get(6).getId(), 5);
        Assertions.assertEquals(list.get(6).getName(), "Tony");
        Assertions.assertEquals(list.get(6).getSalary(), 40000);

        Assertions.assertEquals(list.get(7).getId(), 6);
        Assertions.assertEquals(list.get(7).getName(), "Anders");
        Assertions.assertEquals(list.get(7).getSalary(), 30000);

        Assertions.assertEquals(list.get(8).getId(), 7);
        Assertions.assertEquals(list.get(8).getName(), "Archie");
        Assertions.assertEquals(list.get(8).getSalary(), 26000.45);

        Assertions.assertEquals(list.get(9).getId(), 2);
        Assertions.assertEquals(list.get(9).getName(), "Dave");
        Assertions.assertEquals(list.get(9).getSalary(), 22000.45);

    }

    @Test
    @DisplayName("Checking the employee by id")
    void getEmployeeById() {
        Assertions.assertEquals(getInstance().getEmployeeById(4).getId(), 4);
        Assertions.assertEquals(getInstance().getEmployeeById(4).getName(), "William");
        Assertions.assertEquals(getInstance().getEmployeeById(3).getId(), 3);
        Assertions.assertEquals(getInstance().getEmployeeById(3).getName(), "Amit");
        Assertions.assertEquals(getInstance().getEmployeeById(1).getId(), 1);
        Assertions.assertEquals(getInstance().getEmployeeById(1).getName(), "John");
        Assertions.assertEquals(getInstance().getEmployeeById(2).getId(), 2);
        Assertions.assertEquals(getInstance().getEmployeeById(2).getName(), "Dave");
    }

    @Test
    @DisplayName("Checking if the method is returning highest salary employee")
    void getHighestSalaryEmployee() {
        Employee employee = getInstance().getHighestSalaryEmployee();
        Assertions.assertEquals(employee.getId(), 4);
        Assertions.assertEquals(employee.getName(), "William");
    }

    @Test
    @DisplayName("Checking if the method is returning average salary")
    void getAverageSalary(){
        Assertions.assertEquals(getInstance().getAverageSalary(), 46800.09);
    }

    @Test
    @DisplayName("Checking if the method is returning all the employees by city")
    void getEmployeesByCity() {
        Assertions.assertEquals(getInstance().getEmployeesByCity("Glasgow").size(), 2);
        Assertions.assertEquals(getInstance().getEmployeesByCity("Glasgow").get(0).getId(), 9);
        Assertions.assertEquals(getInstance().getEmployeesByCity("Glasgow").get(1).getId(), 4);

        Assertions.assertEquals(getInstance().getEmployeesByCity("Brighton").size(), 1);
        Assertions.assertEquals(getInstance().getEmployeesByCity("Brighton").get(0).getId(), 1);

        Assertions.assertEquals(getInstance().getEmployeesByCity("Manchester").size(), 2);
        Assertions.assertEquals(getInstance().getEmployeesByCity("Manchester").get(0).getId(), 3);
        Assertions.assertEquals(getInstance().getEmployeesByCity("Manchester").get(1).getId(), 8);
    }

    private EmployeeService getInstance() {
        return new EmployeeService();
    }
}