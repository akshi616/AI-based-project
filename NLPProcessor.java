import java.util.Locale;

public class NLPProcessor {
    public static String preprocess(String input) {
        return input.trim().toLowerCase(Locale.ROOT).replaceAll("[^a-zA-Z0-9\\s]","");
}
}