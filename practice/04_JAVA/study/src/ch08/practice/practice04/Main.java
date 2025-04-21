package ch08.practice.practice04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment[] payments = {
                new CreditCard(),
                new KakaoPay(),
                new KakaoPay(),
                new CreditCard(),
        };
        for (int i = 0; i < 4; i++) {
            System.out.println("[" + (i + 1) + "번 결제수단] 금액을 입력하세요: ");
            int money = sc.nextInt();
            if (payments[i].pay(money)) {
                payments[i].approve();
                payments[i].cancel("테스트 취소");
            }
            else {
                System.out.println("[결제 실패: 승인/취소 건너뜀]");
            }
            System.out.println();
        }
    }
}
