package ch04.practice;

public class Practice07 {
    public static void main(String[] args) {
        int[][] array = {
                { 95, 86 },
                { 83, 92, 96 },
                { 78, 83, 93, 87, 88}
        };
        int sum = 0;
        int count = 0;
        double avg;
        for (int i = 0; i < array.length; i++) {
            count += array[i].length;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        avg = (double) sum / count;
        System.out.println("전체 합: " + sum);
        System.out.println("평균: " + avg);
    }
}
