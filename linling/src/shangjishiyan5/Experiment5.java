package shangjishiyan5;

import java.util.*; // 导入 Java 工具包，包含 Scanner, InputMismatchException 等类

/**
 * 程序主入口类，用于从一个包含菜品和价格的字符串中提取所有价格并计算总和。
 */
public class Experiment5 {
    public static void main(String args[]) {
        // 包含菜单信息的字符串
        String menu = "北京烤鸭:189元 西芹炒肉:12.9元 酸菜鱼:69元 铁板牛柳:32元";

        // 【代码1】: 创建一个 Scanner 对象，但这次不是从键盘读取，而是直接扫描一个已有的字符串。
        Scanner scanner = new Scanner(menu);

        // 定义一个正则表达式，用于设置 Scanner 的分隔符。
        // [^0123456789.]+: 这个表达式的含义是“一个或多个非数字、非小数点的字符”。
        // 也就是说，所有汉字、冒号、"元"和空格都会被当作分隔符。
        String regex = "[^0123456789.]+";

        // 【代码2】: 使用 useDelimiter() 方法，将 Scanner 的默认分隔符（空格）更改为我们定义的正则表达式。
        scanner.useDelimiter(regex);

        // 用于累加所有价格的总和
        double sum=0;

        // 使用 hasNext() 循环，判断是否还有下一个被分隔符隔开的“单词”
        while(scanner.hasNext()){
            try{
                // 【代码3】: 尝试将下一个“单词”作为 double 类型的数字来读取。
                // 由于分隔符的存在，Scanner 会自动跳过所有非数字部分，直接读取数字 "189", "12.9" 等。
                double price = scanner.nextDouble();
                // 将读取到的价格累加到总和中
                sum = sum+price;
                // 打印出本次读取到的价格
                System.out.println(price);
            }
            catch(InputMismatchException exp){
                // 如果一个被分隔符隔开的“单词”不是一个有效的数字（例如，在字符串开头可能有一个空字符串），
                // nextDouble() 会抛出 InputMismatchException 异常。
                // 我们捕获这个异常，并调用 scanner.next() 来跳过这个无效的“单词”，从而让循环继续进行。
                String t = scanner.next();
            }
        }

        // 打印菜单的总价格
        System.out.println("菜单总价格:"+sum+"元");
        scanner.close(); // 关闭 scanner
    }
}