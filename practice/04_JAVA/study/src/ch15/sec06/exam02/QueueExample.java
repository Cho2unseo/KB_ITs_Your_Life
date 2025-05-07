package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queue: 가장 먼저 넣은 값이 가장 먼저 나온다. (FIFO)
        // LinkedList가 Queue의 구현체
        Queue<Message> messageQueue = new LinkedList<>();

        // offer: queue에 값을 넣어주는 메소드
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        // isEmpty: queue가 비어있는지 확인하는 메소드
        while (!messageQueue.isEmpty()) {
            // poll: queue에 가장 먼저 넣은 값부터 꺼내는 메소드
            Message message = messageQueue.poll();
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
