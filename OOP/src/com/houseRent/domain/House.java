package com.houseRent.domain;

/*
House的对象表示一个房屋信息
 */


public class House {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int rent;
    private String state;

    public House(int id, String name, String address, String phone, int rent, String state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //为方便输出对象信息，我们实现toString

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t" + address +
                "\t\t" + phone +
                "\t\t" + rent +
                "\t" + state;
    }
}
