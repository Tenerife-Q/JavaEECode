package com.finalExercise;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, int age, char gender, int work_age) {
        super(name, age, gender);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println(getName() + "要认真教书");
    }

    @Override
    public String play() {
        return super.play() + "chess";
    }

    public void printInfo() {
        System.out.println("Teacher info:");
        System.out.println(super.basicInfo());
        System.out.println("work age:" + work_age);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }
}
