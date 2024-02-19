package exercise;

import java.util.Arrays;

public class App {
    public static String getForwardedVariables(String file) {
        var forwarded = file.split("\n");
        var result = Arrays.stream(forwarded)
                        .filter(arr -> arr.startsWith("environment"))
                                .map(arr -> arr.split("\""))
                .flatMap(elem -> Arrays.stream(elem))
                .map(arr -> arr.split(","))
                .flatMap(elem -> Arrays.stream(elem))
                .filter(elem -> elem.startsWith("X_FORWARDED_"))
                .map(elem -> elem.replaceAll("X_FORWARDED_", ""))
                .toList();
        String res = String.join(",", result);
        return res;
    }
}
