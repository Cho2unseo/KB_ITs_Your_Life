package ch07.practice.practice03;

public class KoreanRecipe extends Recipe {

    public KoreanRecipe() {
        this.title = "김치찌개";
        this.cookTime = 20;
        this.isVegan = false;
    }

    @Override
    public String getDescription() {
        return "매콤한 김치찌개를 추천합니다!";
    }
}
