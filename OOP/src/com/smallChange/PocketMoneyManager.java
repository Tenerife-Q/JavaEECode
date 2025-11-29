package com.smallChange;

import java.util.ArrayList;
import java.util.Date;//日期引入 import
import java.util.Scanner;

public class PocketMoneyManager {
    private double balance = 0;
    private final ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        PocketMoneyManager manager = new PocketMoneyManager();
        manager.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            printMenu();
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    showHistory();
                    break;
                case "2":
                    income(scanner);
                    break;
                case "3":
                    expense(scanner);
                    break;
                case "4":
                    showBalance();
                    break;
                case "5":
                    System.out.println("退出零钱通，欢迎下次使用。");
                    loop = false;
                    break;
                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n======== 零钱通菜单 ========");
        System.out.println("1. 查看收支明细");
        System.out.println("2. 收入入账");
        System.out.println("3. 支出");
        System.out.println("4. 查询余额");
        System.out.println("5. 退出");
        System.out.print("请选择(1-5): ");
    }

    private void showHistory() {
        System.out.println("\n-------- 收支明细 --------");
        if (history.isEmpty()) {
            System.out.println("暂无收支明细。");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }

    private void income(Scanner scanner) {
        System.out.print("请输入收入金额: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("金额必须大于0！");
            return;
        }
        balance += amount;
        String record = String.format("收入\t+%.2f\t%s\t余额: %.2f", amount, new Date(), balance);
        history.add(record);
        System.out.println("入账成功！");
    }

    private void expense(Scanner scanner) {
        System.out.print("请输入支出金额: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("金额必须大于0！");
            return;
        }
        if (amount > balance) {
            System.out.println("余额不足！");
            return;
        }
        balance -= amount;
        System.out.print("请输入支出说明: ");
        String note = scanner.next();
        String record = String.format("%s\t-%.2f\t%s\t余额: %.2f", note, amount, new Date(), balance);
        history.add(record);
        System.out.println("支出成功！");
    }

    private void showBalance() {
        System.out.printf("当前余额为: %.2f 元\n", balance);
    }
}