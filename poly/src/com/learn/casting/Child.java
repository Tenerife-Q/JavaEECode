package com.learn.casting;

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child Method");
    }

    public void specificMethod() {
        System.out.println("Child's Specific Method");
    }
}