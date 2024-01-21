package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var sents = sentence.split(" ");
        HashMap<String, Integer> wordsCount;
        wordsCount = new HashMap<String, Integer>();
        if (sentence.length() == 0) {
            return wordsCount;
        }
        for (var word: sents) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        return wordsCount;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        var result = "";
        for (var entry: wordsCount.entrySet()) {
            result = result + "\n  " + entry.getKey() + ": " + entry.getValue();
        }
        result = wordsCount.isEmpty() ? "{}" : "{" + result + "\n" + "}";
        return result;
    }
}
