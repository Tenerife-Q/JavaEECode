package com.polymorphic.polyarr;

public class Teacher extends Person {
    private double salary;

    public Teacher(int age, String name, double salary) {
        super(age, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + "  salary : " + salary;
    }

    //特有方法
    public void teach() {
        //公有化方法访问私有化属性
        System.out.println("Teacher " + getName() + " sayiloveyou");
    }
}
