public class BookIssuance {
    String bookCopyID;
    String memberID;
    Long issuedTime;
    Long returnTime;

    BookIssuance(String bookCopyID, String memberID) {
        this.bookCopyID = bookCopyID;
        this.memberID = memberID;
        this.issuedTime = System.currentTimeMillis();
    }

    void updateReturnTime() {
        this.returnTime = System.currentTimeMillis();
    }
}
