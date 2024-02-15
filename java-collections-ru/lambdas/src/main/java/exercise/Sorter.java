package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;

public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> mans) {
        var sortedMans = new ArrayList<String>();
        var sorted = mans.stream()
                .filter(a -> a.get("gender").equals("male"))
                .sorted((a, b) -> LocalDate.parse(a.get("birthday")).compareTo(LocalDate.parse(b.get("birthday"))))
                .toList();
        for (var man: sorted) {
            sortedMans.add(man.get("name"));
        }
        return sortedMans;
    }

}
