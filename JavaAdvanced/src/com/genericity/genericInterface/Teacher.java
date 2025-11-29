package com.genericity.genericInterface;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:34
 */

/**
 * 教师类，用于演示泛型接口的实现
 *
 * @author Tenerife
 * @date 2025/10/24 16:34
 */
public class Teacher {
    private int id;
    private String name;
    private String subject;

    public Teacher() {
    }

    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{id=" + id + ", name='" + name + "', subject='" + subject + "'}";
    }
}
