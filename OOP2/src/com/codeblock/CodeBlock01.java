package com.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie tenerife = new Movie("Tenerife");
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    /*
    构造器需要相同的语句 代码看起来比较冗余
    可以把相同的语句放入到代码块中即可
    不管调用哪个构造器，创建对象，都会先调用代码块中内容
    代码块使用顺序优先于构造器
     */


    {
        System.out.println("shibushikuguocaizhengui");
        System.out.println("haishizaojiufenbuqing");
        System.out.println("nishiyouqing");
        System.out.println("haishicuoguodeaiqing");
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}


