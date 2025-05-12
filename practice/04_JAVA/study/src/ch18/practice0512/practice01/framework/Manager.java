package ch18.practice0512.practice01.framework;

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
}
