package ch06.practice.practice01;

public class DatabaseExample {
    public static void main(String[] args) {
        Database obj = Database.getInstance();
        System.out.println("데이터베이스: " + obj.connect());
        obj.close();
    }
}
