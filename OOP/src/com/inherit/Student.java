package com.inherit;

public class Student {
    //共有属性
    public String name;
    public int age;
    private double score;


    //公有方法
    public void setScore(double score) {
        this.score = score;
    }

    public void info(){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("score:"+score);
    }
}
