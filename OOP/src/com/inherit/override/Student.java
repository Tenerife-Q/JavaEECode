package com.inherit.override;

public class Student extends Person {
    private int id;
    private double score;

    public Student(int age, String name, int id, double score) {
        super(age, name);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
        return super.say() + id + "\t" + score;
    }
}
