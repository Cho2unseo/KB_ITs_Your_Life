package ch08.practice.practice04;

public interface Payment {
    boolean pay(int amount);
    void approve();
    void cancel(String reason);
}
