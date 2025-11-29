package com.interface_.introduction;

public class Introduce {
    public static void main(String[] args) {
        Camera_ camera = new Camera_();
        Phone_ phone = new Phone_();

        //将手机和相机接入电脑
        System.out.println("接入电脑 使用同一方法work传入实现接口对象参数：");
        Computer computer = new Computer();
        computer.work(phone);
        computer.work(camera);

        System.out.println("\n传统接口调用：");
        UsbInterface l = new Camera_();
        l.stop();
        l.start();
        UsbInterface v = new Phone_();
        v.stop();
        v.start();

    }
}
