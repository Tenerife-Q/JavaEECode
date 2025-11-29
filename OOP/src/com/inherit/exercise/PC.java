package com.inherit.exercise;

public class PC extends Computer {
    private String brand;

    //调用父类有参构造器，alt+ins 智能生成
    public PC(String cpu, int memory, int disk, String brand) {
        //父类构造器完成父类属性初始化
        super(cpu, memory, disk);
        //子类完成特殊属性初始化
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void info() {
        System.out.println(getDetails() +  getBrand());
    }
}
