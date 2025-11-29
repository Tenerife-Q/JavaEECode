package com.polymorphic.polyarr;

public class PolyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        //创建一个Person类型数组，因为父类引用可以指向子类
        //所以也可以填入Student Teacher类型的对象
        //这里参数填入顺序是按照构造器的顺序
        persons[0] = new Person(1, "Q&S");
        persons[1] = new Student(19, "Tenerife", 137);
        persons[2] = new Student(19, "Susan", 136);
        persons[3] = new Teacher(33, "SYR", 13000);
        persons[4] = new Teacher(11, "QinZi", 25000);

        //循环遍历多态数组，调用say()

        for (int i = 0; i < persons.length; i++) {
            //persons[i]的编译类型是Person，运行类型是根据实际情况由JVM来判断
            System.out.println(persons[i].say());
            //类型判断 向下转型
            if(persons[i] instanceof Student){
                //下面两句等价于((Student)persons[i]).study(); 后面同理
                Student student = (Student) persons[i];
                student.study();
            } else if (persons[i] instanceof Teacher) {
                //else if 是判断数组类对象是否为Teacher 或者 Teacher 类型子类 上下同理
                Teacher teacher = (Teacher) persons[i];
                teacher.teach();
            }else if (persons[i] instanceof Person){
                //不做处理
            }else{
                System.out.println("输入类型有误....");
            }
        }
    }
}
