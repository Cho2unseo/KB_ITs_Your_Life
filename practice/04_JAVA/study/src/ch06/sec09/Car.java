package ch06.sec09;

public class Car {
    String model;
    int speed;

    Car(String model) {
        this.model = model;
    }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    void run() {
        this.setSpeed(100); // this는 객체 자기자신을 의미
        System.out.println(this.model + "가 달립니다. (시속: " + this.speed + "km/h)");
    }
}
