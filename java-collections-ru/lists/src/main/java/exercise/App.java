package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class App {
    public static boolean scrabble(String str, String word) {
        var strs = str.split("");
        var words = word.split("");
        var listOfStr = new ArrayList<String>();
        var listOfWords = new ArrayList<String>();
        Collections.addAll(listOfStr, strs);
        Collections.addAll(listOfWords, words);
        for (var i = 0; i < listOfWords.size(); i++) {
            String temp = listOfWords.get(i).toLowerCase();
            listOfWords.remove(i);
            listOfWords.add(temp);
        }
        for (var i = 0; i < listOfStr.size(); i++) {
            if (listOfWords.contains(listOfStr.get(i))) {
                listOfWords.remove(listOfStr.get(i));
            }
        }
        if (listOfWords.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
