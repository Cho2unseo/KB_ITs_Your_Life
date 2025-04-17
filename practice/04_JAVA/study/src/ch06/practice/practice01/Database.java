package ch06.practice.practice01;

public class Database {
    private static Database singleton = new Database();

    private Database() {

    }

    public static Database getInstance() {
        return singleton;
    }
}
