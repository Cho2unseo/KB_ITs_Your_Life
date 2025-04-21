package ch08.practice.practice05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("선택: ");
        int n = sc.nextInt();
        System.out.print("금액: ");
        int money = sc.nextInt();
        Payment payment = null;
        if (n == 1) {
            payment = new CreditCard();
        }
        else if (n == 2) {
            payment = new KakaoPay();
        }
        if (payment.pay(money)) {
            payment.approve();
            payment.cancel("테스트 취소");
            if (payment instanceof KakaoPay kakaoPay) {
                kakaoPay.sendNotification();
            }
            else System.out.println("[알림 서비스 없음]");
        }
        else {
            System.out.println("[결제 실패: 승인/취소 건너뜀]");
        }
    }
}
