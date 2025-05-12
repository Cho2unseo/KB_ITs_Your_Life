package ch18.practice0512.practice02;

import ch18.practice0512.practice02.framework.Manager;
import ch18.practice0512.practice02.framework.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.register("insta", new CardTemplate("Instagram Story", '*'));
        manager.register("twit", new CardTemplate("Tweet Style", '-'));
        manager.register("short", new CardTemplate("YouTube Shorts", '#'));

        Scanner sc = new Scanner(System.in);
        Map<Product, String> map = new HashMap<>();
        while (true) {
            manager.printRegisteredStyles();
            System.out.println();
            System.out.print("사용할 스타일 이름 입력 (종료: exit): ");
            String s = sc.nextLine();
            if (s.equals("exit")) {
                System.out.println("📦 사용된 카드 목록 출력: ");
                System.out.println();
                for (Map.Entry<Product, String> a: map.entrySet()) {
                    System.out.println(a.getKey());
                }
                break;
            }
            System.out.print("출력할 문구 입력: ");
            String comment = sc.nextLine();
            if (!comment.equals("insta") && !comment.equals("twit") && !comment.equals("short")) {
                System.out.println("[Error] 등록되지 않은 스타일입니다: " + s);
                continue;
            }
            Product p = manager.create(s);
            p.use(comment);
            map.put(p, comment);
            System.out.println();
        }
    }
}
