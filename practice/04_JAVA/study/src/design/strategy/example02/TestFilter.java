package design.strategy.example02;

import java.util.Scanner;

public class TestFilter {
    public static void main(String[] args) {
        System.out.println("📸 AI 필터 엔진에 오신 걸 환영합니다!");
        System.out.println("✨ 사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        while (true) {
            FilterStrategy f = null;
            System.out.print(">> 적용할 필터 입력: ");
            String filter = sc.nextLine().toLowerCase();
            if (filter.equals("exit")) {
                System.out.println("📸 필터 부스를 종료합니다. 안녕히 가세요!");
                break;
            } else if (filter.equals("smooth")) f = new SmoothSkinFilter();
            else if (filter.equals("cute")) f = new CuteEyesFilter();
            else if (filter.equals("kawaii")) f = new KawaiiFilter();
            else {
                System.out.println("⚠️ 존재하지 않는 필터입니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }
            System.out.print(">> 사진 입력: ");
            String pic = sc.nextLine();
            System.out.println("[사용 필터: " + filter + "] => " + f.apply(pic));
            System.out.println();
        }
    }
}
