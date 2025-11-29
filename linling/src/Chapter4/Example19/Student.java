package Chapter4.Example19;

public class Student {
    private int age;   //只有 Student 类中的方法能够访问和修改 age 变量。
                       //任何尝试从 Student 类外部直接访问 age 的操作都会导致编译错误。
    int weight = 100;

    public void setAge(int age) {
       if(age>=7&&age<=28) {
           this.age=age;
       }
    }
    public int getAge() {
       return age;
    }
 }
 
 
 
 
 