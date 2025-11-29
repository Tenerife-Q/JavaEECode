package com.houseRent.service;

/*
业务层
1. 定义House[],保存House对象
2. 响应HouseView的调用
3. 完成对房屋的增删改查各项工作(crud)
 */

import com.houseRent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum = 2;
    private int idCounter = 2;

    public HouseService() {
        houses = new House[10];
    }

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "Tenerife", "海淀", "111", 60000, "未出租");
        houses[1] = new House(2, "Susan", "\t青羊", "112", 30000, "已出租");
    }

    //find方法，返回House对象或者NULL
    public House findById(int findId) {
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }


    //del方法，删除一个房屋信息
    public boolean del(int delId) {
        //先找到要删除房屋的对应下标
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        //注意要减1 不然易造成空指针异常
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }

    //add方法，添加新对象，返回布尔值
    public boolean add(House newHouse) {
        //判断是否可以继续添加 思考在此基础上能否有数组自动扩容机制
        if (houseNum == houses.length) {
            System.out.println("数组已满，不能再添加了。。。");
            return false;
        }
        houses[houseNum++] = newHouse;
        //设置id自增长,更新newHouse id
        newHouse.setId(++idCounter);
        return true;
    }


    public House[] list() {
        return houses;
    }
}
