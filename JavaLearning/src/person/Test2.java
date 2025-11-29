package person;
public class Test2 {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "Tenerife";
        p2.name = "Hormos";
        p1 = p2;
        p2.name = "Jane";
        System.out.println(p1.name + " " + p2.name);
    }
}
