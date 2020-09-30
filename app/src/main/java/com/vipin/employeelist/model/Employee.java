
package com.vipin.employeelist.model;



import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("id")
    private int id;
//    @SerializedName("employee_name")
    private String employee_name;
//    @SerializedName("employee_salary")
    private int employee_salary;
//    @SerializedName("employee_age")
    private int employee_age;

    public Employee(int id, int employee_age, int employee_salary, String employee_name) {
        this.id = id;
        this.employee_age = employee_age;
        this.employee_salary = employee_salary;
        this.employee_name = employee_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }
}
