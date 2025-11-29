package com.debug;

public class DebugExercise {
    public static void main(String[] args) {
        Person susan = new Person("Susan", 19);
        System.out.println(susan);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
