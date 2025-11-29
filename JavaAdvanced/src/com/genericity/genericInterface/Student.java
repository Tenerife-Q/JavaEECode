package com.genericity.genericInterface;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:33
 */

/**
 * 学生类，用于演示泛型接口的实现
 *
 * @author Tenerife
 * @date 2025/10/24 16:33
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + '}';
    }
}