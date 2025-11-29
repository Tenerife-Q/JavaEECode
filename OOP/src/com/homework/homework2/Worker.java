package com.homework.homework2;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSalary() {
        System.out.println("Workers: ");
        super.printSalary();
    }
}
