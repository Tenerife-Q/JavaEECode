package com.genericity.genericMethod;

/**
 * 简单实现泛型方法的打印数组内容、获取最大值和最小值。
 * 使用 `for` 循环通过 `getAge` 方法比较学生年龄大小。
 *
 * @author Tenerife
 * @date 2025/10/24 17:08
 */
public class Generic04Normal {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{10, 20, 30};
        printArray(numbers);

        // 示例：Student数组
        Student[] students = new Student[]{
                new Student(1, "Alice", 20),
                new Student(2, "Bob", 22),
                new Student(3, "Charlie", 19)
        };

        // 打印学生数组
        printArray(students);

        // 找出最年轻的学生
        Student youngest = getMinByAge(students);
        System.out.println("Youngest student: " + youngest);

        // 找出最年长的学生
        Student oldest = getMaxByAge(students);
        System.out.println("Oldest student: " + oldest);
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
     * 找出年龄最小的学生
     *
     * @param students 学生数组
     * @return 最年轻的学生对象
     */
    public static Student getMinByAge(Student[] students) {
        if (students == null || students.length == 0) {
            return null; // 若数组为空，返回null
        }

        Student youngest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() < youngest.getAge()) {
                youngest = students[i]; // 更新为年龄更小的学生
            }
        }
        return youngest;
    }

    /**
     * 找出年龄最大的学生
     *
     * @param students 学生数组
     * @return 最年长的学生对象
     */
    public static Student getMaxByAge(Student[] students) {
        if (students == null || students.length == 0) {
            return null; // 若数组为空，返回null
        }

        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i]; // 更新为年龄更大的学生
            }
        }
        return oldest;
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

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', age=" + age + '}';
        }
    }
}