package exercise.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarUpdateDTO {
    @NotNull
    JsonNullable<String> model;
    JsonNullable<String> manufacturer;
    JsonNullable<Integer> enginePower;
}
