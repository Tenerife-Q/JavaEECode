package com.homework;

public class Employee {
    private String name;
    private double daySalary;
    private int workDays;
    private double grades;

    public Employee(double grades, int workDays, double daySalary, String name) {
        this.grades = grades;
        this.workDays = workDays;
        this.daySalary = daySalary;
        this.name = name;
    }

    public void printSalary() {
        System.out.println(name + " Salary: " + daySalary*workDays*grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }
}
