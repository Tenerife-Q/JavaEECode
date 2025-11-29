package com.equals;

public class Equals1 {
    public static void main(String[] args) {
        Person person1 = new Person("Tenerife", 19, '男');
        Person person2 = new Person("Susan", 19, '女');

        //这里输出false person1这个对象调用其父类Object中equals方法
        //所以此时用来判断两个引用类型对象的的堆内地址是否相同，这里分别new了空间

        System.out.println(person1.equals(person2));

        //但这里要实现两个对象属性完全相同，重写equals使其一样返回true,反之false
        //重写后是同一类型但是否一样则取决于参数

        // 这里只是偷懒测试
        System.out.println(person1);//等价于使用person1.toString()
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        //先判断是不是一种类型 再进行后面的参数判断
        if (obj instanceof Person) {
            //向下转型 因为需要得到传入参数obj(Object)属性
            Person person = (Person) obj;
            //这里粉紫色属性等价于this.xxx
            return name.equals(person.name) && age == person.age && gender == person.gender;
        }
        return false;
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
