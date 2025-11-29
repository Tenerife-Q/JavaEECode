package com.interface_.introduction;

public class Computer {
    public void work(UsbInterface usb) {
        //通过接口调用方法
        usb.start();
        usb.stop();
    }
}
