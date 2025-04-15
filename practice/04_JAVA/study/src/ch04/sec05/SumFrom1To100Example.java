package ch04.sec05;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;

        int i = 1;

        while (i <= 100) {
            sum += i;
            i++;
        }
//        i가 101인 경우 for 문을 탈출하기 때문에 i - 1을 해준다
        System.out.println("1~" + (i - 1) + " 합 : " + sum);
    }
}
