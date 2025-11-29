package com.learn.casting;

public class Test2 {
    public class InstanceofExample {
        public static void main(String[] args) {
            Parent parent = new Child(); // 向上转型
            processObject(parent); // 传入子类对象

            Parent anotherParent = new Parent(); // 父类对象
            processObject(anotherParent); // 传入父类对象
        }

        public static void processObject(Parent obj) {
            if (obj instanceof Child) { // 检查是否可以安全地向下转型
                Child child = (Child) obj; // 向下转型
                child.specificMethod(); // 调用子类特有方法
            } else {
                System.out.println("Object is not a Child instance.");
            }
        }
    }
}
