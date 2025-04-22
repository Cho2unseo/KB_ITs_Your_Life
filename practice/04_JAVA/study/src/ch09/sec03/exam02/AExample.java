package ch09.sec03.exam02;

public class AExample {
    public static void main(String[] args) {
        // B 클래스 내에 있는 인스턴스 필드 및 메소드
        A.B b = new A.B();
        System.out.println(b.field1);
        b.method1();

        // B 클래스 내에 있는 정적 필드 및 메소드
        System.out.println(A.B.field2);
        A.B.method2();
    }
}
