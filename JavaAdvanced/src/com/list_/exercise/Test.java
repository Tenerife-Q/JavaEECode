package com.list_.exercise;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 19:58
 *
 * 完成电影案例
 * 1. 创建电影对象
 * 2. 创建一个电影操作对象 负责对电影的业务处理（上架下架 查询 封杀）
 */
public class Test {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        movieService.start();//快速创建其他类中方法，Alt + Enter
    }
}
