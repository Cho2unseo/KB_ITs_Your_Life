package ch04.practice;

public class Practice01 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) cnt += i;
        }
        System.out.println(cnt);
    }

}
