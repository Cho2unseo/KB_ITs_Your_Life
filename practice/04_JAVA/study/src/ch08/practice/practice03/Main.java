package ch08.practice.practice03;

public class Main {
    public static void main(String[] args) {
        Payment payment = new KakaoPay();
        payment.pay(3000);
        payment.pay(7000);
        payment.approve();
        payment.cancel("오입력");
    }
}
