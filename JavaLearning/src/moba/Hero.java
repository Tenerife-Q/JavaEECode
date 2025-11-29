package moba;
public class Hero {
    String name;
    double HR;
    double buff;
    double attack;
    double attackSpeed;
    double moveSpeed;
    Weapon w;

    public void normalAttack(){
        System.out.println("伤害" + attack * attackSpeed);
    }

    public void setWeapon(Weapon weapon){
        w = weapon;
        attackSpeed += w.attackspeed;
        attack += w.attack;
    }
}
