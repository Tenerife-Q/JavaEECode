package com.homework;

public class Manager extends Employee {
    private double bonus;

    public Manager(double grades, int workDays, double daySalary, String name) {
        super(grades, workDays, daySalary, name);
    }

    public void printSalary() {
        System.out.println("manager " + getName() + " salary  " + (bonus +
                getDaySalary() * getWorkDays() * getGrades()));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
