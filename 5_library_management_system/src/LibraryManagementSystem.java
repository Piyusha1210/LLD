import java.util.*;

public class LibraryManagementSystem {

    private final Map<String, Book> books;
    private final Map<String, BookCopy> bookCopies;
    private final Map<String, Member> members;
    private final Map<String, List<BookIssuance>> issuedBooks;
    private final List<BookIssuance> issuanceHistory;
    private final Integer issuanceLimit;

    public static LibraryManagementSystem instance;

    private LibraryManagementSystem() {
        books = new HashMap<>();
        bookCopies = new HashMap<>();
        members = new HashMap<>();
        issuedBooks = new HashMap<>();
        issuanceHistory = new ArrayList<>();
        issuanceLimit = 3;
    }

    public static LibraryManagementSystem getInstance() {
        if(instance == null) {
            instance = new  LibraryManagementSystem();
        }
        return instance;
    }

    void addBook(Book book) {
        if(books.containsKey(book.isbn)) {
            System.out.println("Book with isbn: " + book.isbn + " already exist.");
            return;
        }
        System.out.println("Book Added Successfully!");
        books.put(book.isbn, book);
    }

    void addBookCopy(BookCopy bookCopy) {
        String isbn = bookCopy.isbn;
        if(!books.containsKey(isbn)) {
            System.out.println("Book with isbn: " + isbn + " doesn't exist.");
            return;
        }
        if(bookCopies.containsKey(bookCopy.copyID)) {
            System.out.println("BookCopy with copyID: " + bookCopy.copyID + " already exist.");
            return;
        }
        System.out.println("BookCopy Added Successfully!");
        bookCopies.put(bookCopy.copyID, bookCopy);
        books.get(isbn).bookCopies.add(bookCopy.copyID);
    }

    void registerMember(Member member) {
        if(members.containsKey(member.memberID)) {
            System.out.println("Member with memberID: " + member.memberID + " already exist.");
            return;
        }
        members.put(member.memberID, member);
        issuedBooks.put(member.memberID, new ArrayList<>());
        System.out.println("Member registered Successfully!");
    }

    void issueBook(String bookCopyID, String memberID) {
        if(!members.containsKey(memberID)) {
            System.out.println("Member doesn't exist");
            return;
        }
        if(!bookCopies.containsKey(bookCopyID)) {
            System.out.println("BookCopy doesn't exist");
            return;
        }

        BookCopy bookCopy = bookCopies.get(bookCopyID);
        if(!bookCopy.isAvailable) {
            System.out.println("BookCopy is not available");
            return;
        }

        if(issuedBooks.get(memberID).size() >= issuanceLimit) {
            System.out.println("Member " + memberID + " has reached the issuance limit.");
            return;
        }

        // check book already issued to this member
        if(checkBookAlreadyIssued(bookCopy.isbn, memberID)) {
            System.out.println("Book " + bookCopy.isbn + " already issued to member: " + memberID);
            return;
        }

        bookCopy.isAvailable = false;
        BookIssuance bookIssuance = new BookIssuance(bookCopyID, memberID);
        issuanceHistory.add(bookIssuance);
        issuedBooks.get(memberID).add(bookIssuance);
        System.out.println("Book issued successfully!");
    }

    void returnBook(String bookCopyID, String memberID) {
        if(!members.containsKey(memberID)) {
            System.out.println("Member doesn't exist");
            return;
        }
        BookIssuance bookIssuance = getBookIssuance(memberID, bookCopyID);
        if(bookIssuance == null) {
            System.out.println("BookIssuance not found for member: " + memberID +
                    " AND book: " + bookCopyID);
            return;
        }

        bookCopies.get(bookCopyID).isAvailable = true;
        bookIssuance.updateReturnTime();
        issuedBooks.get(memberID).remove(bookIssuance);
        System.out.println("Book returned successfully!");
    }

    public List<BookCopy> getAvailableCopies(String isbn) {
        List<BookCopy> availableBooks = new ArrayList<>();
        List<String> bookCopiesList = this.books.get(isbn).bookCopies;
        for(String bookCopyID: bookCopiesList) {
            BookCopy bookCopy = bookCopies.get(bookCopyID);
            if(bookCopy.isAvailable) {
                availableBooks.add(bookCopy);
            }
        }
        return availableBooks;
    }

    private boolean checkBookAlreadyIssued(String isbn, String memberID) {
        List<BookIssuance> issuedBookList =  issuedBooks.get(memberID);
        for(BookIssuance bookIssuance: issuedBookList) {
            BookCopy bookCopy = bookCopies.get(bookIssuance.bookCopyID);
            if(bookCopy.isbn.equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    private BookIssuance getBookIssuance(String memberID, String bookCopyID) {
        List<BookIssuance> issuedBooksList = issuedBooks.get(memberID);
        for(BookIssuance bookIssuance: issuedBooksList) {
            if(bookCopyID.equals(bookIssuance.bookCopyID)) {
                return bookIssuance;
            }
        }
        return null;
    }
}
