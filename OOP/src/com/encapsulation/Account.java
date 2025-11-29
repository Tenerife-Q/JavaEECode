package com.encapsulation;

public class Account {
    private String name;       // 账户名称
    private double balance;    // 账户余额（替代原来的age）
    private String password;   // 账户密码

    // 无参构造
    public Account() {
        this.name = "默认账户";
        this.balance = 0.0;
        this.password = "123456";
    }

    // 有参构造
    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    // 为name添加业务逻辑：必须非空且长度在2-10个字符之间
    public void setName(String name) {
        if (name != null && name.length() >= 2 && name.length() <= 10) {
            this.name = name;  // 去除前后空格
        } else {
            System.out.println("账户名称必须是2-10个非空字符");
            this.name = "默认账户";
        }
    }

    public double getBalance() {
        return balance;
    }

    // 为balance添加业务逻辑：余额不能为负数
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("账户余额不能为负数，已设置为0");
            this.balance = 0.0;
        }
    }

    public String getPassword() {
        return password;
    }

    // 密码业务逻辑：必须是6位数字
    public void setPassword(String password) {
        // 验证密码是否为6位数字
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("密码必须是6位数字，已设置为默认密码");
            this.password = "123456";
        }
    }

    // 显示账户信息（隐藏密码）
    public void info() {
        System.out.println("账户名称: " + name +
                ", 账户余额: " + balance + " 元" +
                ", 密码: " + password);
    }

    // 新增：存款功能
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存款成功！存入金额: " + amount + " 元，当前余额: " + balance + " 元");
        } else {
            System.out.println("存款金额必须大于0");
        }
    }

    // 新增：取款功能
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("取款金额必须大于0");
        } else if (amount > balance) {
            System.out.println("余额不足！当前余额: " + balance + " 元");
        } else {
            balance -= amount;
            System.out.println("取款成功！取出金额: " + amount + " 元，当前余额: " + balance + " 元");
        }
    }
}
