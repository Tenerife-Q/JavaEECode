package com.homework.homework2;

public class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        System.out.println("Scientists: ");
        System.out.println(getName() + " salary: "
                + (getSalary() * getSalMonth() + bonus));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
