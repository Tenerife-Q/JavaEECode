package com.finalExercise;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Tenerife", 19, 'm', "001265");
        student.printInfo();

        System.out.println("================================");

        Teacher teacher = new Teacher("Susan", 18, 'w', 11);
        teacher.printInfo();

        //实现多态数组
        //这里实际是向上转型
        Person[] persons = new Person[4];
        persons[0] = new Student("qin", 17, 'm', "0001");
        persons[1] = new Student("su", 18, 'w', "0002");
        persons[2] = new Teacher("tu", 56, 'w', 33);
        persons[3] = new Teacher("lu", 41, 'w', 27);

        Test test = new Test();
        test.bubbleSort(persons);

        System.out.println("==========After Sort============");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].toString());
        }

        System.out.println("================Quote=================");
        for (int i = 0; i < persons.length; i++) {
            test.quote(persons[i]);
        }

    }


    //向下转型，调用子类特有方法
    public void quote(Person p) {
        //检验对象p的运行类型是不是Student
        if (p instanceof Student) {
            System.out.println();
            Student student = (Student) p;
            student.study();
            System.out.println();
            ((Student) p).printInfo();
        } else if (p instanceof Teacher) {
            System.out.println();
            Teacher teacher = (Teacher) p;
            teacher.teach();
            System.out.println();
            ((Teacher) p).printInfo();
        }
    }


    //冒泡排序 由小到大排列
    public void bubbleSort(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getAge() >= persons[j + 1].getAge()) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }
}
