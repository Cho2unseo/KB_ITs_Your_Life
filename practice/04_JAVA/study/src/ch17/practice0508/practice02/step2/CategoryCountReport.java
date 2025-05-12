package ch17.practice0508.practice02.step2;

import ch17.practice0508.practice02.data.GiftRepository;
import ch17.practice0508.practice02.model.GiftItem;

import java.util.Map;
import java.util.stream.Collectors;

public class CategoryCountReport {
    public static void run() {
        Map<String, Long> map = GiftRepository.getGifts()
                .stream()
                .collect(
                        Collectors.groupingBy(GiftItem::getCategory, Collectors.counting()));
        System.out.println("📦 카테고리별 선물 개수 요약");
        for (Map.Entry<String, Long> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "개");
        }
    }
}
