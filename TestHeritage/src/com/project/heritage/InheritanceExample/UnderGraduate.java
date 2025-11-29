// 文件 UnderGraduate.java
// 子类：UnderGraduate
package com.project.heritage.InheritanceExample;

public class UnderGraduate extends Student {
    private String major; // 主修专业（如计算机科学、数学等）

    // 构造方法：初始化子类属性，同时调用父类构造方法
    public UnderGraduate(String name, int age, String major) {
        super(name, age); // 调用父类构造方法初始化姓名和年龄
        this.major = major; // 初始化子类属性主修专业
    }

    // Getter 方法：获取主修专业
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // 重写 info() 方法：输出子类所有属性
    @Override
    public void info() {
        System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Major: " + major);
    }
}