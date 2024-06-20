package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static Map<String, Integer> getMinMax(int[] array) {

        var maxThread = new MaxThread(array);
        var minThread = new MinThread(array);

        minThread.run();
        maxThread.run();
        minThread.setName("firstThread");
        maxThread.setName("secondThread");


        LOGGER.info(minThread.getName());
        LOGGER.info(maxThread.getName());

        var map = new HashMap<String, Integer>();
        map.put("min", minThread.getMin());
        map.put("max", maxThread.getMax());
        return map;
    }
}
