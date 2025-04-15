package ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0; // 누적값은 바깥에서 초기화
        int i;
        for (i = 1; i <= 100; i++) sum += i; // sum = sum + i
//        i가 101인 경우 for문을 탈출하기 때문에 i- 1 = 100
        System.out.println("1~" + (i - 1) + " 합 : " + sum);
    }
}
