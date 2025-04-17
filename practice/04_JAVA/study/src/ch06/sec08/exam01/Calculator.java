package ch06.sec08.exam01;

public class Calculator {

    // 리턴값이 void면 리턴값이 없다는 뜻
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    // 매개변수가 int 값 두 개이고, int를 리턴하는 함수
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    double divide(int x, int y) {
        double result = (double) x / (double) y;
        return result;
    }


}
