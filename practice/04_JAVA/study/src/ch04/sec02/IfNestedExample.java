package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int) (Math.random() * 20) + 81; // 81~100 범위 중 랜덤값
        System.out.println("점수: " + score);

        String grade;
        if (score >= 90) {
            if (score >= 95) grade = "A+"; // 95점 이상
            else grade = "A"; // 90 ~ 94
        }
        else {
            if (score >= 85) grade = "B+"; // 85 ~ 89
            else grade = "B"; // 81 ~ 84
        }
        System.out.println("학점: " + grade);
    }
}
