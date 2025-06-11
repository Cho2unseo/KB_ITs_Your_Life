package org.scoula.domain;

public class Dog2 {
    private String name;
    private String breed;

    public Dog2(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "[Dog] 이름: " + name + ", 견종: " + breed;
    }
}
