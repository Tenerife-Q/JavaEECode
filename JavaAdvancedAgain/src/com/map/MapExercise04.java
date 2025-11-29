package com.map;

import java.util.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/28 22:37
 * <p>
 * 完成Map集合相关案例 投票统计程序
 */
public class MapExercise04 {
    public static void main(String[] args) {
        calc();
    }

    private static void calc() {
        //1. 把80个同学选择的景点 入程序统计
        List<String> interests = new ArrayList<>();
        String[] names = {"Tenerife", "Stanford Bridge", "Manchester", "Singapore", "Hongkong", "Newcasal"};
        Random r = new Random();
        //Random类型此时
        for (int i = 0; i < 80; i++) {
            //nextInt(bound) 转成int类型 范围 [0,bounnd);
            int index = r.nextInt(names.length);
            interests.add(names[index]);
        }
        System.out.println(interests);

        //2. 键值对形式，所以定义一个Map集合统计结果
        Map<String, Integer> map = new HashMap<>();

        //3. 遍历计票
        for (String interest : interests) {
            //1.
            if (map.containsKey(interest)) {
                map.put(interest, map.get(interest) + 1);
            } else {
                map.put(interest, 1);
            }

            //2.逻辑同上
            map.put(interest, map.containsKey(interest) ? map.get(interest) + 1 : 1);
        }


        System.out.println(map);
        map.forEach((k, v) -> {
            System.out.println(k + " was chose : " + v + " times");
        });
    }
}
