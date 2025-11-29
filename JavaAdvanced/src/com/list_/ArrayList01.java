package com.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 18:39
 *
 * List系列独有功能
 * 包括ArrayList LinekdList 有序 可重复 有索引
 *
 * 这里是ArrayList  查询不同数据时间相同且较快 增删较慢
 */
public class ArrayList01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tenerife");
        names.add("Su san");
        names.add("QinZi");
        System.out.println(names);

        names.add(2,"yunru");
        System.out.println(names);

        //names.remove("yunru");
        System.out.println(names.remove(2));//根据下标删除，可返回删除的数据
        System.out.println(names);

        System.out.println(names.set(2, "qinzi"));//根据下标修改，也可返回替换前的数据
        System.out.println(names);

        System.out.println(names.get(0));

        System.out.println("=====================四种遍历演示=======================");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }


        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        for (String name : names) {
            System.out.println(name);
        }

        names.forEach(n->System.out.println(n));
    }
}
/*
eg.扩容add

如果用无参构造 new ArrayList<>()，第一次真正分配数组（即第一次 add）会把内部容量扩到 10（DEFAULT_CAPACITY）。
之后每次扩容按 1.5 倍增长（准确地说 newCapacity = oldCapacity + (oldCapacity >> 1)），
但如果需要的最小容量更大则扩到最小容量；并且有对超大数组的边界检查（Integer.MAX_VALUE - 少量常数）。

初始状态
无参构造把内部数组设为一个“空标记”常量 DEFAULTCAPACITY_EMPTY_ELEMENTDATA（长度为 0 的占位数组），
并不立即分配大小为 10 的数组以节省内存。
当第一次 add 调用 ensureCapacityInternal(size + 1) 时，如果当前是那个空标记数组，
minCapacity 会被替换为 Math.max(DEFAULT_CAPACITY, minCapacity)，DEFAULT_CAPACITY = 10，
因此第一次分配数组就至少为 10。
 */