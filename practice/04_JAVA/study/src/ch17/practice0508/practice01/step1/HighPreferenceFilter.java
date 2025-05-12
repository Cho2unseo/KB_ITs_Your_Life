package ch17.practice0508.practice01.step1;

import ch17.practice0508.practice01.data.GiftRepository;
import ch17.practice0508.practice01.model.GiftItem;

import java.util.List;
import java.util.stream.Collectors;

public class HighPreferenceFilter {
    public static void run() {
        List<String> list = GiftRepository.getGifts().stream()
                .filter(g -> g.getPreferenceScore() >= 70)
                .map(GiftItem::getName)
                .toList();
        System.out.println("🎁 부모님이 진짜 좋아하시는 선물 리스트");
        for (String s: list) {
            System.out.println(s);
        }
    }

}
