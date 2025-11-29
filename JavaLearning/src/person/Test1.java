package person;
public class Test1{
    public static void main(String[] args){
        Person p = new Person();
        p.name = "Jack";
        p.age = 18;
        System.out.println(p.name);
        System.out.println(p.age);
        p.eat();
        p.speak();
    }
}
