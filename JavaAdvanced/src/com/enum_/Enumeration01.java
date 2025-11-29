package com.enum_;

/**
 * @author Tenerife
 * Su san
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
    }
}

/*
  自定义枚举      用于对象固定 不可增加修改
    1.构造器私有化，防止随意创建对象实例
    2.本类内部创建一组对象（四季）
    3.对外暴露对象 public static final
    4.可以提供get方法，但是不要提供set()
 */

//自定义枚举类
class Season {
    private String name;
    private String description;
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public final static Season SPRING = new Season("Spring", "warm");
    public final static Season SUMMER = new Season("Summer", "hot");
    public final static Season WINTER = new Season("Winter", "cold");
    public final static Season AUTUMN = new Season("Fall", "cool");
}
