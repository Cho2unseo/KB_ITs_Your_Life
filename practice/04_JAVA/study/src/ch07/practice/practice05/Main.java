package ch07.practice.practice05;

public class Main {
    public static void main(String[] args) {
        Recipe[] recipes = {
                new KoreanRecipe(),
                new VeganRecipe(),
                new FusionRecipe(),
        };
        for (int i = 0; i < recipes.length; i++) {
            System.out.println(recipes[i].getDescription());
            if (recipes[i] instanceof KoreanRecipe) {
                System.out.print("→ ");
                System.out.println(((KoreanRecipe) recipes[i]).getSpicinessLevel());
            }
            System.out.println();
        }
    }
}
