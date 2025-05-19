package design.strategy.example02;

public class SmoothSkinFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        return input.toLowerCase() + "✨";
    }
}
