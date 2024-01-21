package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class App {
    public static List findWhere(List<Map<String, String>> listOfBooks, Map<String, String> where) {
        var booki = new ArrayList<Map<String, String>>();
        for (var map: listOfBooks) {
            var book = new Books<>(map.get("author"), map.get("title"), map.get("year"));
            if (where.get("title") == null) {
                if (book.findBook(where.get("author"), where.get("year"))) {
                    var newMap = new HashMap<String, String>();
                    newMap.put("title", book.getTitle());
                    newMap.put("author", book.getAuthor());
                    newMap.put("year", book.getYear());
                    booki.add(newMap);
                }
            } else if (book.findBook(where.get("author"), where.get("year"), where.get("title"))) {
                var newMap = new HashMap<String, String>();
                newMap.put("title", book.getTitle());
                newMap.put("author", book.getAuthor());
                newMap.put("year", book.getYear());
                booki.add(newMap);
            }
        }
        return booki;
    }
}
