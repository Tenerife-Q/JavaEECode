package com.set;

import java.util.Objects;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 14:36
 */
public class Student {
    private String name;
    private int age;
    private String address;
    private String phone;
    public Student(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    //只要两个对象字段都是一样的就是true
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phone, student.phone);
    }

    //hashcode会出现哈希碰撞 小概率不同对象哈希可能相同 所以需要上面方法
    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, phone);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}'+ "\n";
    }
}
