package com.encapsulation;

public class TestAccount {
    public static void main(String[] args) {
        // 测试1：测试无参构造
        System.out.println("\n=== 测试1：无参构造账户 ===");
        Account account1 = new Account();
        account1.info();
        account1.deposit(10000); // 给默认账户存款

        // 测试2：合法参数创建账户
        System.out.println("=== 测试2：合法参数创建账户 ===");
        Account account2 = new Account("Susan", 5000.0, "234618");
        account2.info();

        // 测试3：测试存款和取款功能
        System.out.println("\n=== 测试3：存款和取款 ===");
        account2.deposit(2000);  // 存款
        account2.withdraw(3000); // 取款
        account2.withdraw(5000); // 测试余额不足情况

        // 测试4：测试非法参数
        System.out.println("\n=== 测试4：非法参数处理 ===");
        Account account3 = new Account("d", -1000, "abc123"); // 名称过短、余额为负、密码非数字
        account3.info();


    }
}
