package shangjishiyan3;

/**
 * 实验四：“交通工具”的继承
 * @author Tenerife-Q
 * @date 2025-10-14
 */
public class Experiment4 {
    public static void main(String[] args) {
        System.out.println("========= 实验四：“交通工具”的继承 =========");
        System.out.println("--- 测试Car对象 (使用上转型) ---");
        Vehicle myCar = new Car("Toyota", 180, 5);
        myCar.start();
        myCar.move();

        System.out.println("\n--- 测试Bicycle对象 (使用上转型) ---");
        Vehicle myBicycle = new Bicycle("Giant", 30);
        myBicycle.start();
        myBicycle.move();
    }
}

/**
 * [实验四] 抽象父类 Vehicle
 */
abstract class Vehicle {
    protected String brand;
    protected int maxSpeed;

    public Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public void start() {
        System.out.println(this.brand + " 启动了");
    }

    public abstract void move();
}

/**
 * [实验四] 子类 Car
 */
class Car extends Vehicle {
    private int seats;

    public Car(String brand, int maxSpeed, int seats) {
        super(brand, maxSpeed);
        this.seats = seats;
    }

    @Override
    public void move() {
        System.out.println("汽车在公路上行驶");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("汽车引擎轰鸣！");
    }
}

/**
 * [实验四] 子类 Bicycle
 */
class Bicycle extends Vehicle {
    public Bicycle(String brand, int maxSpeed) {
        super(brand, maxSpeed);
    }

    @Override
    public void move() {
        System.out.println("自行车靠人力踩踏前进");
    }
}