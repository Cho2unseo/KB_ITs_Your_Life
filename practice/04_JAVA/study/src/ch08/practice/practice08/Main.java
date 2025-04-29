//package ch08.practice.practice08;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("=== 유니페이 결제 시스템");
//            System.out.println("[1] 신용카드");
//            System.out.println("[2] 카카오페이");
//            System.out.println("[0] 종료");
//            System.out.print("결제 수단을 선택하세요: ");
//            int n = sc.nextInt();
//            sc.nextLine();
//            if (n == 0) {
//
//                break;
//            }
//            Payment payment = null;
//            if (n == 1) {
//                payment = new CreditCard();
//            }
//            else if (n == 2) {
//                KakaoPay kakaoPay = new KakaoPay();
//                System.out.println("[카카오페이 사용자 인증을 진행하시겠습니까? (y/n)]");
//                String s = sc.nextLine();
//                if (s.equals("y")) kakaoPay.authenticate();
//                if (!payment.beforePay()) {
//                    System.out.println("[결제 실패: 준비 단계에서 중단]");
//                }
//                else {
//                    System.out.print("결제 금액을 입력하세요: ");
//                    int amount = sc.nextInt();
//                    PaymentManager.process(payment, amount);
//                }
//                payment = kakaoPay;
//            }
//        }
//    }
//}
