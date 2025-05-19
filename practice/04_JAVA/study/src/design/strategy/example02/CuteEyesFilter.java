package design.strategy.example02;

public class CuteEyesFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u' ||
            input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U') sb.append("👁️");
            else sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
