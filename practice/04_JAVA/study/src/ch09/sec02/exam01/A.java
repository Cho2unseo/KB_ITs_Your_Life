package ch09.sec02.exam01;

public class A {
    // 인스턴스 멤버 클래스
    class B {}

    B field = new B();

    A()  {
        B b = new B();
    }

    void method() {
        B b = new B();
    }
}
