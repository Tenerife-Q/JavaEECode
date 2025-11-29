package com.innerclass;

//匿名内部类练习2

public class InnerclassExercise02 {
    public static void main(String[] args) {
        /*
        1. 传递的是实现了Bell接口的匿名内部类 InnerclassExercise02$1 / $2
        2. 重写了ring
        3. Bell bell = new Bell(){
                @Override
                public void ring() {
                    System.out.println("懒猪起床!!!!");
                }
            }
         */
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床！！！！");
            }
        });

        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("After Hours....");
            }
        });

        //Lambda 表达式 无参数传入
        cellPhone.alarmclock(() -> {
                System.out.println("Blind Lights....");
        });
    }
}

interface Bell{
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}



/**
 * 1.作用域：CellPhone类中的alarmclock(Bell bell)方法体
 * 2.传入参数：接入Bell类型接口的匿名内部类
 *      cellPhone.alarmclock(new Bell() {
 *             @Override
 *             public void ring() {
 *                 System.out.println("After Hours....");
 *             }
 *         });
 *  ===================================================================================
 *         new Bell(){
 *             @Qverride
 *         };
 *         底层本质上
 *         class InnerclassExercise02$2 implements Bell {
 *             @Override
 *                public void ring() {
 *                    System.out.println("After Hours....");
 *                }
 *         }
 *         传入参数 类似于向上转型 多态
 *         后面方法体alarmclock()中调用ring()方法 进行动态绑定
 * 3. 匿名内部类只使用一次
 *      每一次调用alarmclock(new Bell(){
 *            @Override
 *      });
 *      每次都需要重新底层创建一个匿名内部类包装那个接口
 * 4. 外部类命名
 *      匿名内部类以外部类名字命名 这里是InnerclassExercise02$
 *      匿名内部类限制：
 *        只使用一次：匿名内部类的一个显著特点是它不能被重复使用，每次调用都需要重新创建。
 *        作用域受限：匿名内部类的作用域仅限于它所在的方法或代码块。
 *        适合只需要实现接口或继承类一次性行为的场景。
 */
