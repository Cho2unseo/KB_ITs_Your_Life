package ch18.practice0512.practice02;

import ch18.practice0512.practice02.framework.Product;

public class CardTemplate implements Product {

    private String title;
    private char frameChar;
    private String sentence;

    public CardTemplate(String title, char frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    @Override
    public void use(String content) {
        StringBuilder sb  = new StringBuilder();
        sb.append("[").append(title).append("]\n");
        sb.append(String.valueOf(frameChar).repeat(30));
        sb.append("\n");
        sb.append(content);
        sb.append(String.valueOf(frameChar).repeat(30));
        sb.append("\n");
        sentence = sb.toString();
        System.out.println(sentence);
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
//    public
}

