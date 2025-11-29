package com.exception.homework;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 16:46
 */

public class Homework1 {
    public static void main(String[] args) {

        try {
            if(args.length!=2){
                throw new ArrayIndexOutOfBoundsException("parameter exception");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1,n2);
            System.out.println("Calculate result " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("parameter form exception    Please input number");
        } catch (ArithmeticException e) {
            System.out.println("出现了除数为0");
        }
    }

    public static double cal(int n1,int n2){
        return n1 / n2;
    }
}
