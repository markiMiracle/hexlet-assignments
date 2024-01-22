package exercise;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void initList() {
        this.numbers = new ArrayList<>();
        this.numbers.add(1);
        this.numbers.add(2);
        this.numbers.add(3);
        this.numbers.add(4);
    }

    @Test
    void testTake() {
        var expect = List.of(1, 2);
        var actual = App.take(numbers, 2);

        var expect2 = new ArrayList<>();
        expect2.addAll(numbers);
        var actual2 = App.take(numbers, 8);

        var expect3 = new ArrayList<>();
        var actual3 = App.take(numbers, 0);

        Assertions.assertEquals(expect3, actual3);
        Assertions.assertEquals(expect2, actual2);
        Assertions.assertEquals(expect, actual);
    }
}
