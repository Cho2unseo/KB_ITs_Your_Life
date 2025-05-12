package ch17.practice0508.practice03.step3;

import ch17.practice0508.practice03.data.GiftRepository;
import ch17.practice0508.practice03.model.GiftItem;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MostValuableGift {
    public static void run() {
        boolean momMode = false;
        Optional<GiftItem> item = Optional.empty();
        List<GiftItem> list = GiftRepository.getGifts().stream().toList();
        if (momMode) {
            item = list.stream().filter(GiftItem::isForMom)
                    .max(Comparator.comparingInt(GiftItem::getPrice));
        }
        else {
            item = list.stream().filter(s->s.isForDad() && s.getPreferenceScore() >= 90)
                    .max(Comparator.comparingInt(GiftItem::getPrice));
        }
        System.out.println("💎 부모님께 드릴 수 있는 최고의 프리미엄 선물");
        DecimalFormat df = new DecimalFormat("###,###");
        if (item.isPresent()) {
            GiftItem present = item.get();
            String money = df.format(present.getPrice());
            if (momMode) System.out.println("💝 [" + present.getName() + "] - " + present.getCategory() + " (₩" + money + ") / 선호도: " + present.getPreferenceScore() + "점");
            else System.out.println("🎁 [" + present.getName() + "] - " + present.getCategory() + " (₩" + money + ") / 선호도: " + present.getPreferenceScore() + "점");
        }
        else System.out.println("🥲 조건에 맞는 고가의 선물을 찾지 못했어요.");
    }


}
