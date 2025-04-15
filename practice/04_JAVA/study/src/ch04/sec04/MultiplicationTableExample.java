package ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int m = 2; m <= 9; m++) { // 몇 단인지 표시
            System.out.println("*** " + m + "단 ***");
            for (int n = 1; n <= 9; n++) { // 단마다 곱해주는 수
                System.out.println(m + " x " + n + " = " + (m * n));
            }
        }
    }
}
