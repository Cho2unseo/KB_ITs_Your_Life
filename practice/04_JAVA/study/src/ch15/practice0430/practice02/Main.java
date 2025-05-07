package ch15.practice0430.practice02;

import ch15.practice0430.practice02.queue.DollQueueManager;
import ch15.practice0430.practice02.stack.DollStackManager;
import ch15.practice0430.practice02.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 유라의 인형뽑기 가게 ===");
        System.out.println("[1] 고객 등록");
        System.out.println("[2] 뽑기 진행 (인형 보관)");
        System.out.println("[3] 현재 대기열 보기");
        System.out.println("[4] 보관함 보기");
        System.out.println("[0] 종료");
        while (true) {
            System.out.print("선택 >> ");
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("👋 프로그램을 종료합니다.");
                break;
            }
            else if (n == 1) {
                String name = RandomCustomerProvider.getRandomCustomer();
                DollQueueManager.registerCustomer(name);
            }
            else if (n == 2) {
                DollQueueManager.processNextCustomer();
                DollStackManager.storeRandomDoll();
            }
            else if (n == 3) {
                DollQueueManager.showWaitingList();
            }
            else if (n == 4) {
                DollStackManager.showStack();
            }
        }
    }
}
