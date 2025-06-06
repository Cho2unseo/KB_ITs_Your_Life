package ch18.practice0512.practice01;

import ch18.practice0512.practice01.framework.Product;

public class CardTemplate implements Product {

    private String title;
    private char frameChar;

    public CardTemplate(String title, char frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    @Override
    public void use(String content) {
        System.out.println("[" + title + "]");
        for (int i = 0; i < 30; i++) System.out.print(frameChar);
        System.out.println();
        System.out.println(content);
        for (int i = 0; i < 30; i++) System.out.print(frameChar);
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}

