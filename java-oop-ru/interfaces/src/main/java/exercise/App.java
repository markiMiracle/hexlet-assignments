package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        homes.sort(Comparator.comparing(Home::getArea));
        var houses = new ArrayList<>();
        if (count > homes.size()) {
            houses.addAll(homes);
        } else {
            for (var i = 0; i < count; i++) {
                houses.add(homes.get(i));
            }
        }
        var listOfHouses = houses.stream()
                .map(home -> home.toString())
                .toList();
        return listOfHouses;
    }

}
