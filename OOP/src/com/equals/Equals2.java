package com.equals;

public class Equals2 {
    public static void main(String[] args) {
        // 基本类型比较
        int a = 10;
        int b = 10;
        System.out.println(a == b); // true

        // 引用类型比较
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1 == str2);      // false (不同对象)
        System.out.println(str1.equals(str2)); // true  (内容相同)

        // 自定义类
        Person_ p1 = new Person_("John");
        Person_ p2 = new Person_("John");

        System.out.println(p1 == p2);          // false (不同对象)
        System.out.println(p1.equals(p2));     // false (未重写 equals 方法)

        // 重写 equals 后
        PersonWithEquals p3 = new PersonWithEquals("John");
        PersonWithEquals p4 = new PersonWithEquals("John");

        System.out.println(p3 == p4);          // false (不同对象)
        System.out.println(p3.equals(p4));     // true  (内容相同)
    }
}

class Person_ {
    private String name;

    public Person_(String name) {
        this.name = name;
    }
}

class PersonWithEquals {
    private String name;

    public PersonWithEquals(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonWithEquals that = (PersonWithEquals) obj;
        return name.equals(that.name);
    }
}
