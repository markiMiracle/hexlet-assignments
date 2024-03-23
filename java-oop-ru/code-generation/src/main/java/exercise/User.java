package exercise;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
