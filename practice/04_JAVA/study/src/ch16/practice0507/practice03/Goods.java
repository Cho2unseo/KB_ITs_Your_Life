package ch16.practice0507.practice03;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Goods {
    private String name;
    private String color;
    private boolean useful;

    @Override
    public String toString() {
        return getName() + "(" + getColor() + ")";
    }
}
