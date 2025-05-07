package ch16.practice0507.practice02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static List<Goods> list;

    public static void main(String[] args) {
        list = Arrays.asList(new Goods("메타몽 쿠션", "분홍", false), new Goods("메타몽 노트북 파우치", "보라", true), new Goods("메타몽 인형", "분홍", false), new Goods("메타몽 가방", "회색", true), new Goods("메타몽 키링", "파랑", false));
        Predicate<Goods> isul = (c) -> c.getColor().equals("분홍");
        Predicate<Goods> jiwoo = Goods::isUseful;
        printSelectedGoods("이슬이", isul);
        printSelectedGoods("지우", jiwoo);

    }

    public static void printSelectedGoods(String user, Predicate<Goods> filter) {
        System.out.println("[" + user + "의 선택]");
        for (Goods s: list) {
            if (filter.test(s)) {
                System.out.println("- " + s.getName());
            }
        }
        System.out.println();
    }
}
