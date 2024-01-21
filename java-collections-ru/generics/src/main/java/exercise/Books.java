package exercise;
public class Books<T extends String> {
    private final T author;
    private final T title;
    private final T year;

    public Books(T author, T title, T year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }
    public boolean findBook(String author1, String year1) {
        if (getAuthor().equals(author1) && getYear().equals(year1)) {
            return true;
        }
        return false;
    }
    public boolean findBook(String author1, String year1, String title1) {
        if (getAuthor().equals(author1) && getYear().equals(year1) && getTitle().equals(title1)) {
            return true;
        }
        return false;
    }

    public T getAuthor() {
        return author;
    }

    public T getTitle() {
        return title;
    }

    public T getYear() {
        return year;
    }
}
