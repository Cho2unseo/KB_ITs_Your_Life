package ch08.practice.practice03;

public interface Payment {
    void pay(int amount);
    void approve();
    void cancel(String reason);
}
