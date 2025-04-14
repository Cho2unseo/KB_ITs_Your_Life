package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x 값 입력: ");
        String strX = sc.nextLine(); // 사용자에게 입력값을 String으로 받아옴
        int x = Integer.parseInt(strX); // 받아온 값을 int로 형변환

        System.out.print("y 값 입력: ");
        String strY = sc.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("x + y: " + result);
        System.out.println();
    }
}
