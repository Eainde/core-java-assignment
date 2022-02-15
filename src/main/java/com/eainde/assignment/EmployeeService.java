package com.eainde.assignment;

import com.eainde.assignment.entity.Address;
import com.eainde.assignment.entity.Employee;
import com.eainde.assignment.utility.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> getEmployees() throws IOException {

        FileUtil util= new FileUtil();
        List<String> employeeListInString=util.getFile();
        List<Employee> employeeList = new ArrayList<Employee>();

        //Removing table heads
        employeeListInString.remove(0);

        for(String employee:employeeListInString) {

            String[] employeeDetails = employee.split(",");

            employeeList.add(new Employee(
                    Long.parseLong(employeeDetails[0]),
                    employeeDetails[1],
                    Integer.parseInt(employeeDetails[2]),
                    Double.parseDouble(employeeDetails[3]),
                    employeeDetails[4],
                    new Address(employeeDetails[5],employeeDetails[6],employeeDetails[7],employeeDetails[8])));
        }

        return employeeList;
    }

    /*
     * Orders list by salary ascending order and name
     *
     */

    public List<Employee> sortedEmployees() throws IOException{

        List<Employee> sortedUsers = this.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // add for decending.reversed()
                .collect(Collectors.toList());

        return sortedUsers;
    }

    public Employee getEmployeeById(long id){


        Employee emp = null;

        try {

            for(Employee employee: this.getEmployees()) {

                if(employee.getId()==id) {
                    emp = employee;
                    break;
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return emp;
    }

    /*
     * Calls sorted list, takes last element of list, which is employee of higest salary
     */

    public Employee getHighestSalaryEmployee() throws IOException{

        List<Employee> empList = this.sortedEmployees();
        return empList.get(0);
    }

    public int getAverageSalary() throws IOException{

        OptionalDouble average =
                this.getEmployees().stream()
                        .map(Employee::getSalary)
                        .mapToDouble(a -> a)
                        .average();


        return (int) average.getAsDouble();
    }


    /*
     * Add Employees from city to Hashmap and sort
     */

    public List<Employee> getEmployeesByCity(String city) throws IOException{

        HashMap<String, Employee> hm = new HashMap<String, Employee>();

        for(Employee e:this.getEmployees()) {

            if(e.getAddress().getCity().equals(city)) {
                hm.put(e.getName(), e);
            }
        }

        System.out.print(hm);

        return new ArrayList<Employee>(hm.values());

    }
}