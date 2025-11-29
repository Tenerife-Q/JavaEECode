package com.genericity.genericInterface;

import java.io.Serializable;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:42
 */

import java.util.HashMap;
import java.util.Map;

/**
 * StudentData类，实现泛型接口Data，用于管理Student对象
 *
 * @author Tenerife
 * @date 2025/10/24 16:42
 */
public class StudentData implements Data<Student> {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void add(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("Added: " + student);
    }

    @Override
    public void delete(Student student) {
        studentMap.remove(student.getId());
        System.out.println("Deleted: " + student);
    }

    @Override
    public void update(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("Updated: " + student);
    }

    @Override
    public Student query(int id) {
        System.out.println("Querying for ID: " + id);
        return studentMap.get(id);
    }
}