package exercise;


public class Flat implements Home {
    private double area;
    private double balconyAreaArea;
    private int floor;

    public Flat(double area, double balconyAreaArea, int floor) {
        this.area = area;
        this.balconyAreaArea = balconyAreaArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyAreaArea;
    }

    public double getBalconyAreaArea() {
        return balconyAreaArea;
    }

    public int getFloor() {
        return floor;
    }


    @Override
    public int compareTo(Home another) {
        if (another.getArea() < getArea()) {
            return 1;
        } else if (another.getArea() > getArea()) {
            return -1;
        }
        return 0;
    }


    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }
}
