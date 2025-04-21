package ch08.practice.practice05;

public interface Payment {
    boolean pay(int amount);
    void approve();
    void cancel(String reason);
}
