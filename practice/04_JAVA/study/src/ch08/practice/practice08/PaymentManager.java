package ch08.practice.practice08;

public class PaymentManager {
    public void process(Payment payment, int amount) {
        if (!payment.beforePay()) {
            System.out.println("[준비 실패]");
            return;
        }
        if (!payment.pay(amount)) {
            System.out.println("[결제 실패]");
            return;
        }
        payment.approve();
        payment.cancel("테스트 취소");
        if (payment instanceof KakaoPay) ((KakaoPay) payment).sendNotification();
        else System.out.println("[알림 서비스 없음]");
        Payment.log("로그되");
    }

    public void printSummary() {
        System.out.println("✅ 결제 통계 요약");
    }
}
