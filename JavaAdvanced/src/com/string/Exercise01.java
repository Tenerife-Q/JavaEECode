package com.string;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 15:43
 * hsp P470
 *
 *
 * 总结
 * 原本：main 方法中的变量或成员变量，保存着引用对象的地址。
 * 副本：方法调用时，JVM会把原本变量的值（地址）复制一份传进方法参数，这就是副本。
 * 修改副本的引用，不影响原本；通过副本引用修改对象内容，会影响原本，因为指向同一个对象。
 *
 * 一言以蔽之：
 * Java 方法参数传递时，传递的是“值的副本”，基本类型是数值的副本，引用类型是“地址的副本”。
 * 副本和原本是两个不同的变量，但如果副本和原本的地址一样，他们会指向同一个对象，
 * 操作对象内容会互相影响，操作引用本身不会影响对方。
 *
 */
public class Exercise01 {
    String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str,char ch[]) {
        //改变了形参 str 的引用，使其指向常量池中的 "java" 字符串。
        //不会影响外部的 exercise01.str，因为此时 str 是局部变量，和成员变量没有关系。
        str = "java";
        //通过 ch（引用副本）修改了数组对象的内容。
        //由于副本和原本都指向同一个堆区数组对象，所以这个修改会影响到 exercise01.ch 的内容：数组变为 {'h','a','v','a'}。
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Exercise01 exercise01 = new Exercise01();
        exercise01.change(exercise01.str,exercise01.ch);
        System.out.println(exercise01.str + " " + new String(exercise01.ch));
    }
}
/*
main栈帧：
exercise01（引用，指向 Exercise01 对象）

堆区：
Exercise01对象
str成员变量：指向new String("hsp")对象
ch成员变量：指向char[]数组对象，初始内容是{'j','a','v','a'}

调用change方法时：
change栈帧
str（引用副本，初始指向new String("hsp")，后指向"java"常量池对象，仅限该方法栈帧）
ch（引用副本，指向char[]数组对象，与成员变量指向同一个数组）
 */

