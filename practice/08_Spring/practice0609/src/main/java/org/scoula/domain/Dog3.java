package org.scoula.domain;

public class Dog3 {
    private String name;
    private String breed;

    public Dog3(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "[" + breed + "] " + name;
    }
}
