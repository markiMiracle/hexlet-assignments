package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;

public class App {
    public static void save(Path path, Car car) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(path.toFile(), car);
    }
    public static Car extract(Path path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(path.toFile(), Car.class);
        return car;
    }

}
