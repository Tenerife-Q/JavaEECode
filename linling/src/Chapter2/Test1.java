package Chapter2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        //默认以空格分行 123 abc 456
        int n = sc.nextInt();
        String s = sc.next();//Scanner 原本输出String类型 如果要转换 则在后面添加 int double
        double n1 =  sc.nextDouble();
        System.out.println(n);
        System.out.println(s);
        System.out.println(n1);
    }
}
