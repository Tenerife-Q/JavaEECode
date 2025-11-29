package com.abstract_;

public class Manager extends Employee {
    private double bouns;

    public Manager(String name, int id, double salary, double bouns) {
        super(name, id, salary);
        this.bouns = bouns;
    }

    @Override
    public void work() {
        System.out.println("manager  " + getName() + " is working...");
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
}
