package com.abstract_;

public class worker extends Employee {
    @Override
    public void work() {
        System.out.println("worker " + getName() + " is working...");
    }

    public worker(String name, int id, double salary) {
        super(name, id, salary);
    }
}
