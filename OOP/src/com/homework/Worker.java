package com.homework;

public class Worker extends Employee{
    public Worker(double grades, int workDays, double daySalary, String name) {
        super(grades, workDays, daySalary, name);
    }

    public void printSalary() {
        System.out.print("workers ");
        super.printSalary();
    }
}
