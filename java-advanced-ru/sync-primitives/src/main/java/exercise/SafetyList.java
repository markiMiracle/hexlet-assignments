package exercise;

import java.util.Arrays;

class SafetyList<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public SafetyList() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public SafetyList(int capacity) {
        this.array = new Object[capacity];
    }

    public synchronized void add(T object) {
        if (array.length > size) {
            array[size] = object;
        } else {
            array = Arrays.copyOf(array, (int) ((size + 1) * 1.5));
            array[size] = object;
        }
        size++;
    }

    public T get(int index) {
        if (index <= size) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException("ti pidor");
        }
    }

    public int getSize() {
        return size;
    }
}
