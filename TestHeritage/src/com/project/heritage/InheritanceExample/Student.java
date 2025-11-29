// 文件 Student.java
// 父类：Student
package com.project.heritage.InheritanceExample;

public class Student {
    private String name; // 学生姓名
    private int age;     // 学生年龄

    // 构造方法：初始化父类属性
    public Student(String name, int age) {
        this.name = name; // 使用构造器参数初始化姓名
        this.age = age;   // 使用构造器参数初始化年龄
    }

    // Getter 方法：获取姓名和年龄
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // info() 方法：输出父类属性
    public void info() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}