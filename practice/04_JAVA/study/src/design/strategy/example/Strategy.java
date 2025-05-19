package design.strategy.example;

import design.strategy.example.Hand;

public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
