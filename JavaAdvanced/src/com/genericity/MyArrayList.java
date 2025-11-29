package com.genericity;

import java.util.ArrayList;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:16
 */
public class MyArrayList<E> {

    private ArrayList list = new ArrayList();

    public boolean add(E e) {
        list.add(e);
        return true;
    }

    public boolean remove(E e) {
        return list.remove(e);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "list=" + list +
                '}';
    }
}
