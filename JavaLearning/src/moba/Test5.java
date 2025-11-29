package moba;
public class Test5 {
    public static void main(String[] args) {
        Weapon w = new Weapon();
        w.name = "AK-47";
        w.attack = 500;
        w.attackspeed = 10;

        Hero h = new Hero();
        h.name = "deagle";
        h.attack = 1000;
        h.attackSpeed = 5;
        h.moveSpeed = 10;
        h.HR = 5000;
        h.buff = 600;

        h.setWeapon(w);
        h.normalAttack();
    }
}
