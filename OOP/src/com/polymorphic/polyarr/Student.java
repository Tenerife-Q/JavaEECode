package com.polymorphic.polyarr;

public class Student extends Person {
    private double score;

    public Student(int age, String name, double score) {
        super(age, name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
        return super.say() + "  score : " + score;
    }

    public void study() {
        //公有化方法访问私有化属性
        System.out.println("Student " + getName() + " sayherewego");
    }
}
