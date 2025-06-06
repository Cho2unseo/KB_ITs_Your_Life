package design.strategy.example02;

public class KawaiiFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) sb.append(input.charAt(i));
        sb.append("🌸");
        return sb.toString();
    }
}
