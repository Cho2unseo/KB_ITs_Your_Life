package ch04.practice;

import java.util.Scanner;

public class Practice09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int st = 0;
        int[] arr = new int[0];
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");
            int n = sc.nextInt();
            if (n == 1) {
                System.out.print("학생수> ");
                st = sc.nextInt();
                arr = new int[st];
            }
            else if (n == 2) {
                for (int i = 0; i < st; i++) {
                    System.out.print("scores[" + i + "]> ");
                    arr[i] = sc.nextInt();
                }
            }
            else if (n == 3) {
                for (int i = 0; i < st; i++) {
                    System.out.print("scores[" + i + "]: ");
                    System.out.println(arr[i]);
                }
            }
            else if (n == 4) {
                int cnt = 0;
                int max = arr[0];
                double avg = 0;
                for (int i = 0; i < st; i++) {
                    cnt += arr[i];
                    max = Math.max(max, arr[i]);
                }
                avg = (double) cnt / st;
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);
            }
            else if (n == 5) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}
