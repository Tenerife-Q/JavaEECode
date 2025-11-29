package com.enum_;

/**
 * @author Tenerife
 * Su san
 */
public class EnumExercise {
    public static void main(String[] args) {
        //Season2[] values = Season2.values();
        Week[] weeks = Week.values();
        System.out.println("week as below");
        for (Week week : weeks) {//循环把weeks数组中所有元素取出赋给week变量
            System.out.println(week);
        }
    }
}


enum Week{
    MONDAY("monday"),TUESDAY("tusday"),WEDNESDAY("wednesday"),THURSDAY("thursday"),
    FRIDAY("friday"),SATURDAY("saturday"),SUNDAY("sunday");
    private String name;

    private Week(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}