package com.genericity.genericMethod;

import com.genericity.genericInterface.Student;

/**
 * 简单实现泛型方法的打印数组内容、获取最大值和最小值。
 *
 * @author Tenerife
 * @date 2025/10/24 17:08
 */
public class Generic04 {
    public static void main(String[] args) {
        // 打印任意数组内容
        String[] names = new String[]{"Alice", "Bob", "Charlie"};
        printArray(names);

        Integer[] numbers = new Integer[]{10, 20, 30};
        printArray(numbers);

        // 获取数组中的最大值和最小值
        Integer maxNumber = getMax(numbers);
        System.out.println("Max number: " + maxNumber);

        Integer minNumber = getMin(numbers);
        System.out.println("Min number: " + minNumber);

        // 示例：Student数组
        Student[] students = new Student[]{
                new Student(1, "Alice", 20),
                new Student(2, "Bob", 22),
                new Student(3, "Charlie", 19)
        };
        printArray(students);
    }

    /**
     * 泛型方法：打印任意类型的数组内容
     *
     * @param arr 任意类型的数组
     * @param <T> 泛型类型
     */
    public static <T> void printArray(T[] arr) {
        System.out.println("Array contents:");
        for (T element : arr) {
            System.out.println(element);
        }
    }

    /**
     * 泛型方法：获取数组中的最大值
     *
     * @param arr 数组
     * @param <T> 泛型类型，必须实现Comparable接口
     * @return 数组中的最大值
     */
    public static <T extends Comparable<T>> T getMax(T[] arr) {
        T max = arr[0];
        for (T element : arr) {
            //compareTo方法实际比较的是两个字符的字典序 即字母顺序
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    /**
     * 泛型方法：获取数组中的最小值
     *
     * @param arr 数组
     * @param <T> 泛型类型，必须实现Comparable接口
     * @return 数组中的最小值
     */
    public static <T extends Comparable<T>> T getMin(T[] arr) {
        T min = arr[0];
        for (T element : arr) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}