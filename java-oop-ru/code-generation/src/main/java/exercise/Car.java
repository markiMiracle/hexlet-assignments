package exercise;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

}
