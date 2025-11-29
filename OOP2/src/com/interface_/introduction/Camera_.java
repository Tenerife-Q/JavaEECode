package com.interface_.introduction;

public class Camera_ implements UsbInterface {

    @Override
    public void start() {
        System.out.println("camera start...");
    }

    @Override
    public void stop() {
        System.out.println("camera stop...");
    }
}
