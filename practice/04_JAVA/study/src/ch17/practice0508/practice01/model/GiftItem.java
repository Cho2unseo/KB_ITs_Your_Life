package ch17.practice0508.practice01.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class GiftItem {
    private String name;
    private String category;
    private int price;
    private int preferenceScore;
    private boolean forMom;
    private boolean forDad;
}
