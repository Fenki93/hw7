package org.example.entity;

public class MaxWorkerSalary {
    private String name;
    private int salary;

    public MaxWorkerSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "MaxWorkerSalary{" +
                "Name='" + name + '\'' +
                ", Salary=" + salary +
                '}';
    }
}
