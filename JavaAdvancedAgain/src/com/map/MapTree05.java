package com.map;

import com.set.Teacher;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/28 23:23
 */
public class MapTree05 {
    public static void main(String[] args) {
        Map<Teacher,String> map = new TreeMap<Teacher,String>((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        map.put(new Teacher("Tenerife",19,8000.0),"Barcelona");

        map.put(new Teacher("Su san",22,12888.8),"London");

        map.put(new Teacher("TenerifeSea",21,9998.5),"Norway");

        map.put(new Teacher("Su sanSea",21,9698.5),"Stanford Bridge");

        System.out.println(map);

    }
}
