public class BookCopy {
    String copyID;
    String isbn;
    boolean isAvailable;

    BookCopy(String bookCopyID, String isbn) {
        this.copyID = bookCopyID;
        this.isbn = isbn;
        this.isAvailable = true;
    }
}
