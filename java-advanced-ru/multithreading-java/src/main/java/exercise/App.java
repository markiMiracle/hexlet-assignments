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

        minThread.setName("firstThread");
        maxThread.setName("secondThread");

        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");

        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");


        try {
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }


        var map = new HashMap<String, Integer>();
        map.put("min", minThread.getMin());
        map.put("max", maxThread.getMax());
        return map;
    }
}
