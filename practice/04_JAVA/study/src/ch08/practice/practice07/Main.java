package ch08.practice.practice07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 유니페이 결제 시스템 ===");
        System.out.println("[1] 신용카드");
        System.out.println("[2] 카카오페이");
        System.out.print("결제 수단을 선택하세요: ");
        int n = sc.nextInt();
        sc.nextLine();
        Payment payment = null;
        if (n == 1) payment = new CreditCard();
        if (n == 2) {
            KakaoPay kakaoPay = new KakaoPay();
            System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
            String s = sc.nextLine();
            if (s.equals("y")) {
                kakaoPay.authenticate();
            }
            payment = kakaoPay;
        }
        if (!payment.beforePay()) {
            System.out.println("[결제 실패: 준비 단계에서 중단]");
        }
        else {
            System.out.print("결제 금액을 입력하세요: ");
            int amount = sc.nextInt();
            if (payment.pay(amount)) {
                payment.approve();
                payment.cancel("테스트 취소");
                if (payment instanceof KakaoPay) ((KakaoPay) payment).sendNotification();
                else System.out.println("[알림 서비스 없음]");
            }
            else System.out.println("[결제 실패: 승인/취소 건너뜀]");
        }
    }
}
