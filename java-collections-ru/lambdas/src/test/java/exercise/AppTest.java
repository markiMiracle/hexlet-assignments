package exercise;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {
    String[][] image2 = {
            {"*", "*", "*", "*"},
            {"*", " ", " ", "*"},
            {"*", " ", " ", "*"},
            {"*", "*", "*", "*"},
    };
    String[][] image1 = {
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"},
            {"*", "*", "*", "*"}
    };

    @Test
    void testEmtyApp() {
        String[][] expect = {};
        String[][] act = {};
        Arrays.stream(expect).toList();
        Arrays.stream(act).toList();
        var actual = App.enlargeArrayImage(act);
        Assertions.assertEquals(Arrays.deepToString(expect), Arrays.deepToString(actual));
    }

    @Test
    void testApp1() {
        String[][] expect = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        var actual = App.enlargeArrayImage(image1);
        Assertions.assertEquals(Arrays.deepToString(expect), Arrays.deepToString(actual));
    }
    @Test
    void testApp2() {
        String[][] expect = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };
        var actual = App.enlargeArrayImage(image2);
        Assertions.assertEquals(Arrays.deepToString(expect), Arrays.deepToString(actual));
    }
}
