package exercise;

public class NegativeRadiusException extends Exception {

    public NegativeRadiusException(String message) {
        super(message);
    }

    public static void exeption(int radius) throws Exception {
        if (radius < 0) {
            throw new Exception();
        }
    }
}
