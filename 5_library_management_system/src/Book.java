import java.util.ArrayList;
import java.util.List;

public class Book {
    String isbn;
    String title;
    String author;
    List<String> bookCopies;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        bookCopies = new ArrayList<>();
    }
}
