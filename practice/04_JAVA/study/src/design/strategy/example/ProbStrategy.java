package design.strategy.example;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0; // 이전에 낸 손의 인덱스
    private int currentHandValue = 0; // 이번에 낼 손의 인덱스
    private int[][] history = {
            { 1, 1, 1, }, // 바위를 낸 후 상대가 바위/가위/보를 낼 확률
            { 1, 1, 1, }, // 가위를 낸 후 상대가 바위/가위/보를 낼 확률
            { 1, 1, 1, }, // 보를 낸 후 상대가 바위/가위/보를 낼 확률
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    // 현재 손에서 가능한 다음 손들의 가중치 총합 계산
    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) sum += history[handvalue][i];
        return sum;
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;

        // 누적 확률 분포 기반으로 선택
        if (bet < history[currentHandValue][0]) {
            handvalue = 0; // 바위
        }
        else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1; // 가위
        }
        else handvalue = 2; // 보

        // 이전 손과 현재 손 기록 저장
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;

        // 선택된 손 객체 반환
        return Hand.getHand(handvalue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            // 이겼다면 해당 손 조합의 가중치 증가
            history[prevHandValue][currentHandValue]++;
        }
        else {
            // 졌다면 해당 손 이외의 나머지 두 조합 가중치 증가
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }

    }
}
