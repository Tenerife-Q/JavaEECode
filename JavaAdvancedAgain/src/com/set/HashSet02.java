package com.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 14:35
 *
 * HashSet集合去重操作
 */
public class HashSet02 {
    public static void main(String[] args) {
        Student s1 = new Student("Tenrife",22,"Hongkong","177");
        Student s2 = new Student("Tenrife",22,"Hongkong","177");
        Student s3 = new Student("Su san",24,"Singapore","187");
        Student s4 = new Student("Su san",24,"Singapore","187");

        //Set方法去重 hashCode() equals()
        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);
    }
}
