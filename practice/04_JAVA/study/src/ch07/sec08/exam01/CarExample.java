package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.tire = new Tire();
        myCar.run();

        myCar.tire = new HankookTire();
        myCar.run();


        // 같은 메소드를 호출하더라도 Tire 타입에 따라 출력문이 다르다.
        // 다형성: 사용 방법은 동일하지만 실행 결과가 다양하다.
        myCar.tire = new KumhoTire();
        myCar.run();
    }
}
