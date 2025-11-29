package com.map;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 22:24
 *
 * Map集合键值对的三种遍历方式
 */
public class MapTraversal03 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tenerife",19);
        map.put("Su san",21);
        map.put("Tenerife",17);
        map.put("QinZi",12);
        map.put("qinzi",10);
        System.out.println(map);

        //遍历方式（1）
        //提取Map集合的全部键到一个Set集合中
        Set<String> keys = map.keySet();//提取键
        System.out.println(keys);

        //遍历Set集合得到每一个键
        for (String key : keys) {
            Integer value = map.get(key);//遍历键提取值
            System.out.println(key + ":" + value);
        }


        //遍历方式（2）
        //键值对混合类型 先键值打包 再依次遍历提取
        Set<Map.Entry<String, Integer>> entries = map.entrySet();//map.entrySet().var
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" + value);
        }


        //遍历方式（3）
        //lambda 直接调用Map集合forEach()遍历
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+ ":" + integer);
            }
        });

        /**
         * default void forEach(BiConsumer<? super K, ? super V> action) {
         *         Objects.requireNonNull(action);
         *         //action 为上面调的匿名内部类对象
         *
         *         for (Map.Entry<K, V> entry : entrySet()) {
         *              //这里entry : entrySet()增强for循环 Map.Entry<K,V>混合类型接受<String,Integer>
         *              //</>  </> entrySet()前面省略了this.  this指的是调用entrySet()方法的map
         *
         *             //"Map.forEach 的默认实现通过遍历 map.entrySet()，
         *             //对每个 entry 先取 key 和 value，然后调用传入的 BiConsumer.accept(key, value)。
         *             //功能上与遍历方式（2）中从 entry 获取 key/value 并处理是等效的，
         *             //但有重要差别：forEach 只传递 key 和 value（不暴露 entry 对象），而且在回调中结构性修改原 map 会导致并发修改异常。
         *             //只会返回key value 不会给出entry引用 即不可使用entry调用相应方法 而上面遍历方式（2）就可以得到entry操作
         *
         *             K k;
         *             V v;
         *             try {
         *                 k = entry.getKey();
         *                 v = entry.getValue();
         *             } catch (IllegalStateException ise) {
         *                 // this usually means the entry is no longer in the map.
         *                 throw new ConcurrentModificationException(ise);
         *             }
         *
         *             //回调accept()方法
         *             action.accept(k, v);
         *         }
         *     }
         */

        map.forEach((k, v) -> System.out.println(k + ":" + v));
        //典型的匿名内部类实现接口并且类内只有一个方法 此方法即是核心业务逻辑代码（eg：排序）直接函数式Lambda参数指向核心业务逻辑
        //有些时候不用管源码底层 开发只是解决问题 直接使用lambda表达式 这才是该记住的
    }
}
