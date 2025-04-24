package ch14.practice.practice01;

public class TicketingRound1 {
    public static void main(String[] args) {
        System.out.println("=== run() 직접 호출 테스트 ===");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        thread.setName("팬1");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread1.setName("팬2");

        thread.run();
        thread.start();
    }
}
