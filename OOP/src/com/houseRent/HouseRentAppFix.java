package com.houseRent;

import com.houseRent.view.HouseViewFix;

/**
 * HouseRentAppFix
 * 程序入口类（Main Application Bootstrap）。
 *
 * 职责：
 * - 启动视图层主菜单
 * - 结束后输出退出提示
 *
 * 说明：
 * - 当前直接通过 new 启动，没有依赖注入框架（如 Spring），结构简单。
 * - 后期可：
 *   1. 抽出 ApplicationContext，集中初始化 Service / Config
 *   2. 增加启动参数解析（args 传配置文件路径等）
 *   3. 加入日志系统（如使用 SLF4J + Logback）
 */
public class HouseRentAppFix {
    public static void main(String[] args) {
        // 创建视图层对象，进入主菜单循环
        new HouseViewFix().mainMenu();
        System.out.println("=== 你已退出房屋出租系统 ===");
    }
}