package exercise;

public class MaxThread extends Thread {
    private int[] array;
    private int max;
    public MaxThread(int[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        max = array[0];
        for (var i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }
    public Integer getMax() {
        return max;
    }
}
