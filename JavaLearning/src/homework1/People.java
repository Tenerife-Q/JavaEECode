package homework1;

public class People {
    String name;
    Gun gun;

    public void attack(String n){
        System.out.println(name + "use" + gun.name + "shoot" + n);
        gun.shoot();
    }
}
