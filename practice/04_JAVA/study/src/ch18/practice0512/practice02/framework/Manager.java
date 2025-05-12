package ch18.practice0512.practice02.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> card = new HashMap<>();

    public void register(String name, Product p) {
        card.put(name, p);
    }

    public Product create(String pName) {
        Product p = card.get(pName);
        return p.createCopy();
    }

    public void printRegisteredStyles() {
        System.out.println("[등록된 스타일 목록]");
        System.out.println("- insta : Instagram Story");
        System.out.println("- twit : Tweet Style");
        System.out.println("- short : YouTube Shorts");
    }
}
