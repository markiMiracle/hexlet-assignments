package exercise;


public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public int roundSquare() throws NegativeRadiusException {
        var sq = getSquare();
        var roundNum = (int) sq;
        if ((double) roundNum + 0.6 >= sq) {
            return roundNum + 1;
        } else {
            return roundNum;
        }
    }

    public double getSquare() throws NegativeRadiusException {
        try {
            NegativeRadiusException.exeption(radius);
            return 3.1415 * radius * radius;

        } catch (Exception e) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
    }
}
