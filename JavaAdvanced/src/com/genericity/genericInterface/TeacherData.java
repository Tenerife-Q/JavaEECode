package com.genericity.genericInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * TeacherData类，实现泛型接口Data，用于管理Teacher对象
 * 
 * @author Tenerife
 * @date 2025/10/24 16:42
 */
public class TeacherData implements Data<Teacher> {
    private final Map<Integer, Teacher> teacherMap = new HashMap<>();

    @Override
    public void add(Teacher teacher) {
        teacherMap.put(teacher.getId(), teacher);
        System.out.println("Added: " + teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherMap.remove(teacher.getId());
        System.out.println("Deleted: " + teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMap.put(teacher.getId(), teacher);
        System.out.println("Updated: " + teacher);
    }

    @Override
    public Teacher query(int id) {
        System.out.println("Querying for ID: " + id);
        return teacherMap.get(id);
    }
}