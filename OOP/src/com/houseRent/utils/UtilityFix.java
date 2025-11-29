package com.houseRent.utils;

import java.util.Scanner;

/**
 * UtilityFix
 * 控制台输入工具类：统一封装 Scanner 读取、循环校验、默认值逻辑。
 *
 * 设计意图：
 * - 避免在 View 中重复写 try-catch + parse + while 循环。
 * - 所有方法为 static，开箱即用，减少对象管理负担。
 * - readKeyBoard() 作为底层“核心引擎”，其它方法是语义化包装。
 *
 * 线程说明：
 * - 当前是简单教学场景，使用静态 Scanner；若用于多线程或并发输入场景，需要重新设计（避免共享阻塞）。
 *
 * 扩展建议：
 * - 可加入超时功能
 * - 可提供正则匹配版：readPattern(String regex)
 * - 可引入函数式接口将校验策略参数化
 */
public class UtilityFix {

    /** 全局唯一 Scanner（读取标准输入 System.in） */
    private static final Scanner scanner = new Scanner(System.in);

    // ================== 菜单选择相关 ==================

    /**
     * 兼容旧接口：读取菜单（固定范围 1-5）
     * 不推荐直接使用（因为菜单项变化时容易忘记同步范围）
     */
    public static char readMenuSelection() {
        return readMenuSelection('1', '5');
    }

    /**
     * 指定字符范围的菜单选择读取（如 '1' - '6'）
     * @param minChar 最小字符
     * @param maxChar 最大字符
     * @return 用户输入的合法单字符
     *
     * 逻辑：
     * 1. 强制读取一个字符
     * 2. 检查是否在范围内，否则循环提示
     */
    public static char readMenuSelection(char minChar, char maxChar) {
        while (true) {
            String str = readKeyBoard(1, false);
            char c = str.charAt(0);
            if (c >= minChar && c <= maxChar) {
                return c;
            }
            System.out.print("选择错误，请输入" + minChar + "-" + maxChar + "：");
        }
    }

    /**
     * int 版本（更符合业务调用习惯）
     * @param min 最小数字（如 1）
     * @param max 最大数字（如 6）
     * @return 输入的字符形式（仍保留字符方便 switch）
     */
    public static char readMenuSelection(int min, int max) {
        return readMenuSelection((char) (min + '0'), (char) (max + '0'));
    }

    // ================== 基础读取 ==================

    /**
     * 读取 1 个字符（不允许为空）
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 读取 1 个字符，允许空（空则返回默认值）
     * @param defaultValue 默认值
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 读取整数（不允许为空），直到用户输入合法数字
     * @return 解析成功的 int
     */
    public static int readInt() {
        while (true) {
            String str = readKeyBoard(10, false); // 最长 10 位，足够 int
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
    }

    /**
     * 读取整数（允许直接回车：返回默认值）
     * @param defaultValue 默认值
     */
    public static int readInt(int defaultValue) {
        while (true) {
            String str = readKeyBoard(10, true);
            if ("".equals(str)) {
                return defaultValue;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
    }

    /**
     * 读取一个长度 1..limit 的字符串（不允许空）
     * @param limit 最大长度
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 读取一个字符串，允许直接回车返回默认值
     * @param limit 最大长度
     * @param defaultValue 回车时返回
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 专用于“确认选择”的读取：只接受 Y/N（忽略大小写）
     * @return 'Y' 或 'N'（均为大写）
     */
    public static char readConfirmSelection() {
        System.out.print("请输入你的选择(Y/N): ");
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            char c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                return c;
            }
            System.out.print("选择错误，请重新输入(Y/N)：");
        }
    }

    // ================== 底层输入核心 ==================

    /**
     * 底层输入方法：所有公开读取接口的核心依赖。
     *
     * @param limit       输入允许的最大长度
     * @param blankReturn 是否允许返回空串（true 表示：用户直接按回车可返回 ""）
     * @return 合法的字符串（可能是 ""——仅当 blankReturn = true）
     *
     * 行为策略：
     * 1. 循环读取一整行
     * 2. 若行为空：
     *    - blankReturn = true → 立即返回空串
     *    - blankReturn = false → 继续读
     * 3. 若长度 > limit → 提示并继续
     * 4. 返回用户输入
     *
     * 设计说明：
     * - 没有在此做正则/语义校验，保持通用性；语义校验交给上层封装。
     * - scanner.hasNextLine() 失败时返回 ""（EOF 情况下避免阻塞或抛异常）。
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line;
        while (true) {
            if (!scanner.hasNextLine()) {
                return ""; // EOF 情况（如输入流关闭）直接返回空串
            }
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    // 不允许空，继续读取
                    continue;
                }
            }
            if (line.length() > limit) {
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            return line;
        }
    }
}