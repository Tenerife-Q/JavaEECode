package com.houseRent.utils;

/**
 * TestUtilityFix
 * 用于独立测试 UtilityFix 工具类的简单行为。
 *
 * 说明：
 * - 该类不是单元测试框架（如 JUnit）形式，仅用于手工运行验证。
 * - 可以按需添加更多演示：
 *   testReadInt();
 *   testReadConfirm();
 *   ...
 *
 * 后续建议：
 * - 引入 JUnit5，编写自动化测试覆盖：
 *   - 正常输入
 *   - 边界值（空输入、超长、非法字符）
 *   - 模拟输入流（可用 ByteArrayInputStream）
 */
public class TestUtility {
    public static void main(String[] args) {
        System.out.println("测试菜单选择(1-3)，请输入：");
        char c = UtilityFix.readMenuSelection(1, 3);
        System.out.println("你选择了: " + c);

        System.out.println("测试 readInt ，请输入数字：");
        int num = UtilityFix.readInt();
        System.out.println("你输入了: " + num);

        System.out.println("测试确认(Y/N)：");
        char yn = UtilityFix.readConfirmSelection();
        System.out.println("你的确认结果: " + yn);
    }
}