package ch07.practice.practice03;

public class Recipe {
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public String getDescription() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s(%s분) - %s", title, cookTime, (isVegan ? "비건" : "비건 아님"));
    }
}
