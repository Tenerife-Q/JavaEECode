package com.genericity.genericInterface;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:33
 */
public interface Data<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
    T query(int id);
}
