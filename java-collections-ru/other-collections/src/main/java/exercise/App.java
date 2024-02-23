package exercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        var set1 = new TreeSet<>();
        var set2 = new TreeSet<>();
        var result = new LinkedHashMap<String, String>();
        for (var data: data1.entrySet()) {
            set1.add(data.getKey());
        }
        for (var data: data2.entrySet()) {
            set2.add(data.getKey());
        }
        var set = new TreeSet<>();
        set.addAll(set1);
        set.addAll(set2);
        for (var elem: set) {
            if (set1.contains(elem) && !set2.contains(elem)) {
                result.put((String) elem, "deleted");
            } else if (!set1.contains(elem) && set2.contains(elem)) {
                result.put((String) elem, "added");
            } else if (set1.contains(elem) && set2.contains(elem)) {
                if (data2.get(elem).equals(data1.get(elem))) {
                    result.put((String) elem, "unchanged");
                } else {
                    result.put((String) elem, "changed");
                }
            }
        }
        return result;
    }
}
