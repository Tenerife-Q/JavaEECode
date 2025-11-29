package com.homework.homework2;

public class Teacher extends Employee {
    private int classDays;
    private double classSalary;

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    public void printSalary() {
        System.out.println("Teachers: " + '\n' + getName() + " salary: "
                + (getSalary() * getSalMonth() + classSalary * classDays));
    }

    public int getClassDays() {
        return classDays;
    }

    public void setClassDays(int classDays) {
        this.classDays = classDays;
    }

    public double getClassSalary() {
        return classSalary;
    }

    public void setClassSalary(double classSalary) {
        this.classSalary = classSalary;
    }
}
