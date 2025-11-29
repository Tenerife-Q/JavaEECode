// 文件 Test.java
// 测试类：用于运行整个程序
package com.project.heritage.InheritanceExample;

public class Test {
    public static void main(String[] args) {
        // 创建 Graduate 对象并测试
        Graduate graduate = new Graduate("Alice", 25, "Master's Degree");
        System.out.println("Graduate Info:");
        graduate.info(); // 输出：Name: Alice, Age: 25, Degree: Master's Degree

        // 创建 UnderGraduate 对象并测试
        UnderGraduate underGraduate = new UnderGraduate("Bob", 20, "Computer Science");
        System.out.println("\nUnderGraduate Info:");
        underGraduate.info(); // 输出：Name: Bob, Age: 20, Major: Computer Science
    }
}