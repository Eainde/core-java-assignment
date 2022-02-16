package com.eainde.assignment.entity;

public class Employee {
    private long id;
    private int age;
    private String name;
    private Address address;
    private double salary;
    private String designation;


    public Employee(long id, String name, int age, double salary, String designation, Address address){
        this.id=id;
        this.age=age;
        this.name=name;
        this.salary=salary;
        this.designation=designation;
        this.address=address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        //Discuss this
        boolean isEqual = false;

        if (o instanceof Employee){
            Employee e = (Employee) o;
            if (e.id == this.id) {
                isEqual = true;
            }
        }

        return isEqual;
    }


    @Override
    public int hashCode() {

        return this.toString().hashCode();
    }

    @Override
    public String toString(){
        // TODO write a code implement this method
        return "***************" + "\n" +
                "Employee ID: "+id + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age+ "\n"+
                "Salary: " + salary + "\n" +
                "Address: " + address.toString();
    }
}