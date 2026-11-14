//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem instance = LibraryManagementSystem.getInstance();

        instance.addBook(new Book("123", "GOT", "RR Martin"));
        instance.addBook(new Book("123", "House of dragon", "RR Martin"));
        instance.addBook(new Book("234", "House of dragon", "RR Martin"));
        instance.addBook(new Book("456", "Song of Ice & Fire", "RR Martin"));
        instance.addBook(new Book("567", "Iron throne", "RR Martin"));

        System.out.println("-------------------------------");

        instance.addBookCopy(new BookCopy("abc","123"));
        instance.addBookCopy(new BookCopy("bcd","123"));
        instance.addBookCopy(new BookCopy("cde","234"));
        instance.addBookCopy(new BookCopy("def","234"));
        instance.addBookCopy(new BookCopy("def","234"));
        instance.addBookCopy(new BookCopy("fgh","456"));
        instance.addBookCopy(new BookCopy("ghi","456"));
        instance.addBookCopy(new BookCopy("hij","789"));

        System.out.println("-------------------------------");

        instance.registerMember(new Member("xyz","Piyush", "", ""));
        instance.registerMember(new Member("uvw","Ayush", "", ""));

        System.out.println("-------------------------------");

        instance.issueBook("abc", "xyz");
        instance.issueBook("abc", "xyz"); // same copy twice
        instance.issueBook("bcd", "xyz"); // same title twice

        instance.issueBook("bcd", "uvw");

        instance.issueBook("cde", "xyz");
        instance.issueBook("fgh", "xyz");
        instance.issueBook("ghi", "xyz"); // 4th book

        instance.issueBook("ghi", "uvx"); // invalid member


        System.out.println("-------------------------------");
        instance.returnBook("fgh", "xyz"); // successfull return
        instance.returnBook("ghi", "xyz"); // Book issuance not found

    }
}