package com.genericity.genericInterface;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:32
 *
 * 泛型接口
 */

/**
 * 泛型接口的使用示例类
 *
 * 该类主要用来演示如何使用泛型接口，并且可以通过具体类的实现
 * 演示对不同类型数据的操作。
 *
 * @author Tenerife
 * @date 2025/10/24 16:32
 */
public class Generic03 {
    public static void main(String[] args) {
        // 创建StudentData对象，并操作Student对象
        StudentData studentData = new StudentData();
        Student student = new Student(1, "Alice", 20);
        studentData.add(student);
        studentData.update(new Student(1, "Alice Updated", 21));
        System.out.println(studentData.query(1));
        studentData.delete(student);

        // 创建TeacherData对象，并操作Teacher对象
        TeacherData teacherData = new TeacherData();
        Teacher teacher = new Teacher(1, "Mr. Smith", "Mathematics");
        teacherData.add(teacher);
        teacherData.update(new Teacher(1, "Mr. Smith Updated", "Physics"));
        System.out.println(teacherData.query(1));
        teacherData.delete(teacher);
    }
}
