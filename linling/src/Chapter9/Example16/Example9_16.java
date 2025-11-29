package Chapter9.Example16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example9_16 {
    public static void main(String args[]) {
        File file = new File("src\\Chapter9\\Example16\\student.txt");
        System.out.println("尝试读取文件: " + file.getAbsolutePath()); // 调试信息

        Scanner sc = null;
        int count = 0;
        double sum = 0;

        try {
            sc = new Scanner(file, "GBK"); // 明确指定字符编码
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?"); // 匹配整数或小数

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println("读取行: " + line); // 调试信息
                
                Matcher matcher = pattern.matcher(line);
                
                while (matcher.find()) {
                    String scoreStr = matcher.group();
                    double score = Double.parseDouble(scoreStr);
                    count++;
                    sum += score;
                    System.out.println("找到分数: " + score); // 调试信息
                }
            }

            if (count > 0) {
                double aver = sum / count;
                String str = String.format("%.3f", aver);
                System.out.println("平均成绩:" + str);
            } else {
                System.out.println("没有找到任何分数。");
            }
        } catch (FileNotFoundException exp) {
            System.out.println("文件未找到: " + exp.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}