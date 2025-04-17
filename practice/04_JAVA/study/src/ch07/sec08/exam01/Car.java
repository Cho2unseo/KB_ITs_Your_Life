package ch07.sec08.exam01;

public class Car {
    public Tire tire; // 다른 클래스의 객체 (HAS-A 관계)

    public void run() {
        tire.roll();
    }
}
