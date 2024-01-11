package model;

public class BookImpl implements Book{

    private long id;
    private String isbn;
    private String title;
    private String author;
    private double averageRating;
    private String language;
    private int year;
    public BookImpl(){};
    public BookImpl(long id, String isbn, String title, String author, double averageRating, String language, int year) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.averageRating = averageRating;
        this.language = language;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getAuthors() {
        return author;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public double getAverageRating() {
        return averageRating;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookImpl{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", averageRating=" + averageRating +
                ", language='" + language + '\'' +
                ", year=" + year +
                '}';
    }
}
