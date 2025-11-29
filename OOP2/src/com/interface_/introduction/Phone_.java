package com.interface_.introduction;

public class Phone_ implements UsbInterface {
    @Override
    public void start() {
        System.out.println("phone start...");
    }

    @Override
    public void stop() {
        System.out.println("phone stop...");
    }
}
