package com.inherit;

public class Extends1 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = " Tenerife ";
        pupil.age = 10;
        pupil.setScore(98.5);
        pupil.test();
        pupil.info();

        System.out.println();


        Graduate graduate = new Graduate();
        graduate.name = " Susan ";
        graduate.age = 20;
        graduate.setScore(97.5);
        graduate.test();
        graduate.info();
    }
}
