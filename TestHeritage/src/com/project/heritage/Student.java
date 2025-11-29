package com.project.heritage;

public class Student extends Person{
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
        System.out.println("Student constructor");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void info() {
        //父类  超类  基类
        //super.info();
        System.out.println("Name " + this.getName() + " Age " + super.getAge() + " School " + this.getSchool());
    }//this 我自己的  super 我继承的
}
