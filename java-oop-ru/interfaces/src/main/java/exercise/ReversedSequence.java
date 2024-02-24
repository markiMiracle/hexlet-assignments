package exercise;



import java.util.stream.IntStream;

public class ReversedSequence implements CharSequence {
    private String string;

    public ReversedSequence(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        var result = "";
        for (var i = 0; i < string.length(); i++) {
            result = string.charAt(i) + result;
        }
        return result;
    }
    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    @Override
    public char charAt(int i) {
        return toString().charAt(i);
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public String subSequence(int start, int end) {
        if (start > length()) {
            return "";
        }
        if (end > length()) {
            return toString().substring(start, length());
        }
        return toString().substring(start, end);
    }
}
