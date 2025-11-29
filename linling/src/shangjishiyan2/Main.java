package shangjishiyan2;

public class Main {
    public static void main(String[] args) {
        int num1 = 100;
        int num2 = 30;

        // Calculator 和 Main 在同一个包中，可以直接调用
        int sum = Calculator.add(num1, num2);
        int difference = Calculator.subtract(num1, num2);

        System.out.println("演示在同一个包内调用类：");
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + difference);
    }
}