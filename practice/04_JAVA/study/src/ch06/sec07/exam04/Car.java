package ch06.sec07.exam04;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // 생성자 선언
    Car() {}

//    매개변수의 타입, 개수, 순서가 다를 경우 생성자 오버로딩 가능
    Car(String model) {
        this.model = model;
    }

    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
