package com.homework;

public class Homework1 {
    public static void main(String[] args) {
        //new Manager(1.2,30,200,"Tenerife");
        Manager manager = new Manager(1.2,30,200,"Tenerife");
        manager.setBonus(60000);
        manager.printSalary();

        Worker worker = new Worker(1, 31, 100, "Susan");
        worker.printSalary();
    }


}
