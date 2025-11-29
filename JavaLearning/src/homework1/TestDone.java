package homework1;

public class TestDone {
    public static void main(String[] args) {
        Gun deagle = new Gun();
        deagle.name = "AK47";
        People p1 = new People();
        People p2 = new People();

        p1.name = "小王";
        p2.name = "小李";
        p1.gun = deagle;

        p1.attack(p2.name);
    }
}
