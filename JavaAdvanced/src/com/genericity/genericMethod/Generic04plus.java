package com.genericity.genericMethod;

import com.genericity.genericInterface.Student;

/**
 * 简单实现泛型方法的打印数组内容、获取最大值和最小值。
 * 不使用Comparable，通过简单的字符串比较逻辑实现，比较的是名字长度。
 *
 * @author Tenerife
 * @date 2025/10/24 17:08
 */
public class Generic04plus {
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
        Student StudentWithlongestName = getMax(students);
        System.out.println("Max StudentWithlongestName: " + StudentWithlongestName);

        Student studentWithShortestName = getMin(students);
        System.out.println("Student with the shortest name: " + studentWithShortestName);
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
     * 此处比较的是元素的字符串表示的长度。
     *
     * @param arr 数组
     * @param <T> 泛型类型
     * @return 数组中的最大值
     */
    public static <T> T getMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // 若数组为空，返回null
        }
        T max = arr[0];
        for (T element : arr) {
            // 使用字符串长度进行比较
            //在 Java 中，泛型 T 是一个未知类型，编译器无法直接判断元素本身的属性（如长度）。
            //toString()重写 将所有元素统一转换为字符串，确保可以调用 length()。
            if (element.toString().length() > max.toString().length()) {
                max = element;
            }
        }
        return max;
    }

    /**
     * 泛型方法：获取数组中的最小值
     * 此处比较的是元素的字符串表示的长度。
     *
     * @param arr 数组
     * @param <T> 泛型类型
     * @return 数组中的最小值
     */
    public static <T> T getMin(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // 若数组为空，返回null
        }
        T min = arr[0];
        for (T element : arr) {
            // 使用字符串长度进行比较
            if (element.toString().length() < min.toString().length()) {
                min = element;
            }
        }
        return min;
    }

    /**
     * 学生类，用于演示泛型方法的实现。
     */
    static class Student {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', age=" + age + '}';
        }
    }
}





//package com.genericity.genericMethod;
//
//import com.genericity.genericInterface.Student;
//
///**
// * 简单实现泛型方法的打印数组内容、获取最大值和最小值。
// * 不使用Comparable，仅通过简单的排序逻辑实现。
// *
// * @author Tenerife
// * @date 2025/10/24 17:08
// */
//public class Generic04plus {
//    public static void main(String[] args) {
//        // 打印任意数组内容
//        String[] names = new String[]{"Alice", "Bob", "Charlie"};
//        printArray(names);
//
//        Integer[] numbers = new Integer[]{10, 20, 30};
//        printArray(numbers);
//
//        // 获取数组中的最大值和最小值
//        Integer maxNumber = getMax(numbers);
//        System.out.println("Max number: " + maxNumber);
//
//        Integer minNumber = getMin(numbers);
//        System.out.println("Min number: " + minNumber);
//
//        // 示例：Student数组
//        Student[] students = new Student[]{
//                new Student(1, "Alice", 20),
//                new Student(2, "Bob", 22),
//                new Student(3, "Charlie", 19)
//        };
//        printArray(students);
//        Student youngest = getMin(students);
//        System.out.println("Youngest student: " + youngest);
//    }
//
//    /**
//     * 泛型方法：打印任意类型的数组内容
//     *
//     * @param arr 任意类型的数组
//     * @param <T> 泛型类型
//     */
//    public static <T> void printArray(T[] arr) {
//        System.out.println("Array contents:");
//        for (T element : arr) {
//            System.out.println(element);
//        }
//    }
//
//    /**
//     * 泛型方法：获取数组中的最大值
//     *
//     * @param arr 数组
//     * @param <T> 泛型类型
//     * @return 数组中的最大值
//     */
//    public static <T> T getMax(T[] arr) {
//        if (arr == null || arr.length == 0) {
//            return null; // 若数组为空，返回null
//        }
//        T max = arr[0];
//        for (T element : arr) {
//            // 使用简单的字符串比较作为排序逻辑
//            //compareTo比较的是两个字符的字母顺序
//            if (element.toString().compareTo(max.toString()) > 0) {
//                max = element;
//            }
//        }
//        return max;
//    }
//
//    /**
//     * 泛型方法：获取数组中的最小值
//     *
//     * @param arr 数组
//     * @param <T> 泛型类型
//     * @return 数组中的最小值
//     */
//    public static <T> T getMin(T[] arr) {
//        if (arr == null || arr.length == 0) {
//            return null; // 若数组为空，返回null
//        }
//        T min = arr[0];
//        for (T element : arr) {
//            // 使用简单的字符串比较作为排序逻辑
//            if (element.toString().compareTo(min.toString()) < 0) {
//                min = element;
//            }
//        }
//        return min;
//    }
//}
//*/