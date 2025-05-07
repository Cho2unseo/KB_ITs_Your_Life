package ch15.practice0430.practice03.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    static Queue<String> queue = new LinkedList<>();

    public static void registerCustomer(String name) {
        queue.offer(name);
        System.out.println("👉 " + name + " 님이 대기열에 등록되었습니다.");
    }

    public static String processNextCustomer() {
        String first = null;
        if (queue.isEmpty()) {
            System.out.println("⛔️ 대기 중인 고객이 없습니다.");
        }
        else {
            first = queue.poll();
            System.out.println("🎉 " + first + " 님! 인형 뽑기 하러 오세요!");
        }
        return first;
    }

    public static void showWaitingList() {
        int i = 0;
        System.out.print("🧾 현재 대기열: [");
        if (queue.isEmpty()) System.out.println("]");
        else {
            for (String s: queue) {
                System.out.print(s);
                if (i != queue.size() - 1) System.out.print(", ");
                else System.out.println("]");
                i++;
            }
        }
    }
}
