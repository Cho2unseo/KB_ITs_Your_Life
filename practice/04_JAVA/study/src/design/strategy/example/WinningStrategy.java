package design.strategy.example;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) { // 직접 게임에서 졌다면
            prevHand = Hand.getHand(random.nextInt(3)); // 랜덤으로 새 손 선택
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win; // 승패 결과 저장
    }
}
