package com.homework.homework2;

public class Homework2 {
    public static void main(String[] args) {
        Worker ji = new Worker("Ji", 1000);
        ji.printSalary();

        Peasant yan = new Peasant("Yan", 1200);
        yan.printSalary();

        Teacher susan = new Teacher("Susan", 8000);
        susan.setClassDays(360);
        susan.setClassSalary(200);
        susan.setSalMonth(11);
        susan.printSalary();

        Scientist tenerife = new Scientist("Tenerife", 100000);
        tenerife.setBonus(500000);
        tenerife.printSalary();
    }
}
