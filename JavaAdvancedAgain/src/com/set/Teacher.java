package com.set;

/**
 * @author Tenerife
 * @date 2025/10/27 15:14
 *
 * Teacher 实体：包含注释，便于在代码旁直接理解 compareTo 的行为
 */
public class Teacher implements Comparable<Teacher>{
    private String name;    // 教师姓名
    private int age;        // 年龄（当前 compareTo 用此字段）
    private double salary;  // 薪水（在 Set03 的 Comparator 中作为排序字段）

    public Teacher(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter / Setter（简洁，不再对每个方法重复注释）
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }


    // 1) 如果 TreeSet 构造时不传 Comparator，则会调用该 compareTo 方法进行比较
    // 2) 当前实现按 age 升序比较；如果年龄相同（返回 0），TreeSet 会认为两个对象相等并去重
    @Override
    public int compareTo(Teacher o) {
        // 当前实现（简洁）：按年龄升序
        // 警告：不要用 this.age - o.age（有溢出风险），建议使用 Integer.compare（如下面注释）
        // 推荐写法（更安全）：
        // return Integer.compare(this.age, o.age);

        return this.getAge() - o.getAge(); // 当前代码：按 age 升序
    }

    // 可选：如果你需要在 HashSet 等基于 equals 的集合中也能合理去重，请同时重写 equals() 和 hashCode()
}