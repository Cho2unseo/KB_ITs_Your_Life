package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Stack: 가장 마지막에 넣은 값이 가장 먼저 나온다. (LIFO)
        Stack<Coin> coinBox = new Stack<Coin>();

        // push: 스택에 값을 넣어주는 메소드
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        // isEmpty: stack이 비어있는지 확인하는 메소드
        while (!coinBox.isEmpty()) { // 비어있지 않을 때 반복
            // pop: stack에서 마지막에 넣어준 값을 꺼내주는 메소드
            Coin coin = coinBox.pop(); // 꺼내고 나면 사라진다.
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
        }
    }
}
