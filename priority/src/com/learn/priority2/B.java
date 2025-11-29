package com.learn.priority2;

import com.learn.priority.A;

public class B extends A {
    public void fun(){
        //无法访问private default内容  不同包下子类
        this.c = 1;
        this.d = 2;
    }
}
