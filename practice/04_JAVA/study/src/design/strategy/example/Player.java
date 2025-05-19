package design.strategy.example;

public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // 다음에 낼 손 결정(전략 객체에 위임)
    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true); // 전략 객체에 이겼다고 학습시킴
        wincount++;
        gamecount++;
    }

    public void lose() {
        strategy.study(false); // 전략 객체에 졌다고 학습시킴
        losecount++;
        gamecount++;
    }

    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "[" +
                name + ":" +
                gamecount + " games, " +
                wincount + " win, " +
                losecount + " lose" + "]";
    }
}
