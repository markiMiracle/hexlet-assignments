package exercise;

public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        for (var element : map.toMap().entrySet()) {
            var key = element.getKey();
            var value = element.getValue();
            map.unset(key);
            map.set(value, key);
        }
    }
}
