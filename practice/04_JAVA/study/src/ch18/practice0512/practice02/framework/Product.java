package ch18.practice0512.practice02.framework;

public interface Product extends Cloneable {
    void use(String content);
    Product createCopy();
}
