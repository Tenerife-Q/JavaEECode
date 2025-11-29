package com.abstract_;

public class AbstractEx {
    public static void main(String[] args) {
        Manager tenerife = new Manager("Tenerife", 99, 50000,10000);
        tenerife.work();

        worker su = new worker("su", 9, 8000);
        su.work();

    }
}
