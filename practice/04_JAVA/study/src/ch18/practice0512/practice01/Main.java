package ch18.practice0512.practice01;

import ch18.practice0512.practice01.framework.Manager;
import ch18.practice0512.practice01.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        CardTemplate insta = new CardTemplate("Instagram Post", '~');
        CardTemplate youtube = new CardTemplate("YouTube Thumbnail", '#');

        manager.register("insta", insta);
        manager.register("youtube", youtube);

        Product p1 = manager.create("insta");
        p1.use("오늘 점심은 연남동 김밥 🍙");
        System.out.println();

        Product p2 = manager.create("youtube");
        p2.use("🔥 자바로 구현한 내 인생 첫 프로그램!");
    }
}
