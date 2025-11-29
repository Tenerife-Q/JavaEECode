package com.exception.try_;

import java.util.Scanner;

/**
 * @author Tenerife
 * Su san
 */
public class TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";
        while (true){

            System.out.println("input number");
            inputStr = scanner.next();//scanner.nextLine()是整行输入 只是next()会因为空格断点
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Your input is not a number    Please input number corrently");
            }
        }

        System.out.println("input number is " + num);
    }
}
