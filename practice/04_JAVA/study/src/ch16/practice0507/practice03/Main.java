package ch16.practice0507.practice03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    List<Goods> giftPool = Arrays.asList(
            new Goods("메타몽 쿠션", "분홍", false),
            new Goods("메타몽 키링", "파랑", false),
            new Goods("메타몽 텀블러", "보라", true),
            new Goods("메타몽 노트북 파우치", "회색", true),
            new Goods("메타몽 인형", "분홍", false),
            new Goods("메타몽 가방", "회색", true)
    );

    public List<Goods> pickGifts(List<Goods> pool) {
        List<Goods> list = new ArrayList<>();
        double rd = Math.random();
        int index = (int)Math.round(rd * pool.size() - 1);
        for (int i = 0; i < 2; i++) {
            list.add(pool.get(index));
            pool.remove(index);
        }
        return list;
    }

    public void printResult(String user, List<Goods> picks, Predicate<Goods> condition, String successMsg, String failMsg) {

    }
}
