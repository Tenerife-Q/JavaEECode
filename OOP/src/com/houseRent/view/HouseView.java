package com.houseRent.view;

/*
1.显示界面
2.接受用户输入
3.调用HouseService完成对房屋信息的各项操作
*/

import com.houseRent.domain.House;
import com.houseRent.service.HouseService;
import com.houseRent.utils.Utility;


public class HouseView {
    private boolean loop = true;
    public char key = ' ';
    private HouseService houseService = new HouseService(10);


    //根据id修改房屋信息
    public void update() {
        System.out.println("==========修改房屋信息==========");
        System.out.println("请选择待修改房屋编号(-1退出)");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("========你放弃修改房屋信息========");
            return;
        }

        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("====修改房屋信息编号不存在====");
            return;
        }

        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, "");
        if (!name.equals("")) {
            house.setName(name);
        }

        System.out.println("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!address.equals("")) {
            house.setAddress(address);
        }

        System.out.print("电话(" + house.getPhone() + "): ");
        String phone = Utility.readString(11, "");
        if (!phone.equals("")) {
            house.setPhone(phone);
        }

        System.out.print("租金(" + house.getRent() + "): ");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }

        System.out.print("状态(" + house.getState() + "): ");
        String state = Utility.readString(3, "");
        if (!state.equals("")) {
            house.setState(state);
        }

        System.out.println("==========修改房屋信息成功==========");
    }

    //根据id查找房屋信息
    public void findHouse() {
        System.out.println("==========查找房屋信息==========");
        System.out.println("请输入要查找的id");
        int findId = Utility.readInt();

        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("========没有找到相应id房屋信息========");
        }
    }


    //完成确认退出
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //编写delHouse()接收输入id，调用Service del方法
    public void delHouse() {
        System.out.println("==========删除房屋信息==========");
        System.out.println("请输入要删除的房屋信息编号(-1放弃删除)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==========放弃删除房屋信息==========");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("==========删除成功==========");
            } else {
                System.out.println("==========房间编号不存在，删除失败==========");
            }
        } else if (choice == 'N') {
            System.out.println("放弃删除");
        }
    }


    //编写addHouse()接收输入，创建House对象，调用add方法
    public void addHouse() {
        System.out.println("==========添加房屋==========");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("电话: ");
        String phone = Utility.readString(11);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);
        //创建一个新的House对象，id自增长
        House newHouse = new House(0, name, address, phone, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("==========添加成功==========");
        } else {
            System.out.println("==========添加失败==========");
        }
    }

    //编写listHouse()显示房屋列表
    public void listHouses() {
        System.out.println("==========房屋列表==========");
        System.out.println("编号\t\t房主\t\t\t地址\t\t电话\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
        System.out.println("========房屋列表显示完毕========\n");
    }

    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("\n==========房屋出租系统==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 显示房屋信息");
            System.out.println("\t\t\t6 退出系统");
            System.out.println("请输入你的选择1-6");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }
}
