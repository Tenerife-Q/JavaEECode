// 文件 Graduate.java
// 子类：Graduate
package com.project.heritage.InheritanceExample;

public class Graduate extends Student {
    private String degree; // 学位（如硕士、博士等）

    // 构造方法：初始化子类属性，同时调用父类构造方法
    public Graduate(String name, int age, String degree) {
        super(name, age); // 调用父类构造方法初始化姓名和年龄
        this.degree = degree; // 初始化子类属性学位
    }

    // Getter 方法：获取学位
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    // 重写 info() 方法：输出子类所有属性
    @Override
    public void info() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Degree: " + this);
    }
}