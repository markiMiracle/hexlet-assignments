package exercise;


public class MinThread extends Thread {
    private int[] array;
    private int min;
    public MinThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        min = array[0];
        for (var i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    }

    public Integer getMin() {
        return min;
    }
}