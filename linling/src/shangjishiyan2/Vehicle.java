package shangjishiyan2;

public class Vehicle {
    double speed = 0;
    int power = 0;

    void speedUp(int s) {
        speed = speed + s;
    }

    void speedDown(int d) {
        speed = speed - d;
    }

    void setPower(int p) {
        power = p;
    }

    int getPower() {
        return power;
    }

    double getSpeed() {
        return speed;
    }

    void brake(){
        speed = 0;
    }
}