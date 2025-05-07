package ch15.practice0430.practice02.stack;

import java.util.Stack;

public class DollStackManager {
    static Stack<String> stack = new Stack<>();

    public static void storeRandomDoll() {
        String s = "피카츄, 리자몽, 꼬부기, 쿠로미, 헬로키티, 뽀로로, 짱구, 도라에몽, 스폰지밥, 미니언";
        String[] dolls = s.split(", ");
        double rd = Math.random();
        int num = (int) Math.round(rd * (dolls.length - 1));
        String dollName = dolls[num];
        stack.push(dollName);
        System.out.println("🧸 " + dollName + " 인형이 보관함에 추가되었습니다.");
    }

    public static void showStack() {
        if (stack.isEmpty()) System.out.println("보관된 인형이 없습니다.");
        else {
            int idx = 0;
            System.out.print("🧸 현재 보관 중인 인형: [");
            for (String s: stack) {
                System.out.print(s);
                if (idx != stack.size() - 1) System.out.print(", ");
                idx++;
            }
            System.out.println("]");
        }
    }

}
