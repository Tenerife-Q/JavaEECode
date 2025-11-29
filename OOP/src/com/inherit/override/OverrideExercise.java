package com.inherit.override;

public class OverrideExercise {
    public static void main(String[] args) {
        Person susan = new Person(10, "Susan");
        System.out.println(susan.say());

        Student tenerife = new Student(19, "Tenerife", 36746, 98.5);
        System.out.println(tenerife.say());
    }
}
