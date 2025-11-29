package com.finalExercise;

public class Student extends Person {
    private String stu_id;

    public Student(String name, int age, char gender, String stu_id) {
        super(name, age, gender);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println(getName() + "会认真学习");
    }

    @Override
    public String play() {
        return super.play() + "football";
    }

    public void printInfo() {
        System.out.println("Student info:");
        System.out.println(super.basicInfo());
        System.out.println("id: " + getStu_id());
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                '}' + super.toString();
    }
}
