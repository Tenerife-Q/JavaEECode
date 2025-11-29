package keywords;

//vo/javaBean/pojo/entity类用于数据库映射
public class Person {
    private String name;
    private int age;

    public void setName(String n){
        name = n;
    }


    public String getName(){
        return name;
    }
    //private下面生成 set get 可以 alt + insert 自动添加

    /*public int getAge() {
        return age;
    }

//Getter and Setter

    public void setAge(int age) {
        this.age = age;
    }*/

    //构造方法与类名相同并且没有void
    public Person(){
        System.out.println("这是构造方法");
    }
    //构造方法的重载
    public Person(String name,int age){//带参数的构造方法
        this.name = name;
        this.age = age;
    }
}
