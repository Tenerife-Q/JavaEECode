package com.homework.homework2;

public class Peasant extends Employee{
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        System.out.println("Peasants: ");
        super.printSalary();
    }
}
