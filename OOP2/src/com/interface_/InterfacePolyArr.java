package com.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {
        //多条数组 接口类型
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        for( int i = 0; i < usbs.length; i++ ){
            usbs[i].work();
            if( usbs[i] instanceof Phone){
                ((Phone) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}

class Phone implements Usb{
    public void call(){
        System.out.println("Phone call");
    }

    @Override
    public void work() {
        System.out.println("Phone work");
    }
}

class Camera implements Usb{

    @Override
    public void work() {
        System.out.println("Camera work");
    }
}
