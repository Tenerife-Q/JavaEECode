package com.polymorphic;

//属性没有重写一说 方法和属性不一样

class Parent {
    String name = "父类属性";
}

class Child extends Parent {
    // 子类声明同名属性，隐藏父类属性（不是重写）
    String name = "子类属性";
}

public class AttributeDemo {
    public static void main(String[] args) {
        Parent parent = new Child(); // 向上转型
        System.out.println(parent.name); // 访问父类的属性（静态绑定）→ 输出：父类属性

        Child child = new Child();
        System.out.println(child.name); // 访问子类的属性 → 输出：子类属性
    }
}


//属性访问是静态绑定（编译时确定），和引用类型有关。
//方法调用是动态绑定（运行时确定），和实际对象类型有关。
//属性访问的“静态绑定”
//访问属性时，看引用变量的编译类型（左侧类型），而不是实际对象类型（右侧 new 出来的对象）。
//这和方法的多态（动态绑定）完全不同。