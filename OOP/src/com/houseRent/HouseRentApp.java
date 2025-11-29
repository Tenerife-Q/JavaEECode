package com.houseRent;

import com.houseRent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，并显示主菜单
        new HouseView().mainMenu();
        /*
        因为创建对象名称接收没有用处，上面作用等同于下面注释
        HouseView houseView = new HouseView();
        houseView.mainMenu();
        */
        System.out.println("===你已退出房屋出租系统===");
    }
}
