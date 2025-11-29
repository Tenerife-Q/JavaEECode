package com.exception.try_;

/**
 * @author Tenerife
 * Su san
 */
public class TryCatchDetail02 {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.getName());//NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//ArithmeticException
            // 1. 如果try代码块有多个异常，可以用多个catch分别捕获，再相应处理，按照先后顺序处理，不然会跳过
        } catch (NullPointerException e) {
            System.out.println("exception : " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("exception : " + e.getMessage());
            // 2. 但是要求子类异常写在最前面，父类异常写在后面 Exception就是上面两个的父类
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());
        }
    }
}

    class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }