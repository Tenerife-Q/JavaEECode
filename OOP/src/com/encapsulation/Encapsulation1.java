package com.encapsulation;
//封装
public class Encapsulation1 {
    //要求输入年龄名字满足限制
    //且薪水不能直接访问
    //可以在getSalary()中加限制权限

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("S");
        person.setAge(36);
        person.setSalary(30000);
        System.out.println(person.info());


        Person susan = new Person("Susan", 20, 30000);
        System.out.println(susan.info());
    }


}

class Person {
    private String name;  // 改为private，增强封装
    private int age;
    private double salary;

    // 无参构造
    public Person() {}

    // 带参构造
    public Person(String name, int age, double salary) {
        setName(name);//等价于this.set
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字长度必须在2-6之间");
            this.name = "Tenerife";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年龄必须在1-120之间");
            this.age = 19;
        }
    }

    public double getSalary() {
        // 示例：只有成年人可以查看薪水
        if (age >= 18) {
            return salary;
        } else {
            System.out.println("未成年人无权查看薪水");
            return 0.0;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "name=" + name + ", age=" + age + ", salary=" + getSalary();
    }
}