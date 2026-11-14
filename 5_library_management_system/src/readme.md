# Entities

- Book
  - ISBN
  - title
  - Author

- BookCopy
  - copyID
  - bookID/isbn
  - isAvailable

- Member
  - ID
  - name

- BookIssuance
  - BookCopy
  - Member
  - issuedDate
  - returnDate

- availableBooks <isbn, Set<BookCopy>>  
this will help in check availability of copy of a book, when book will be added or returned to 
library will be added here, and in case of issuance will be checked availability here 
and removed from this map

- issuedBooks <memberID, Set<BookIssuance>>
When we will issue a book to a user will add entry there and in case of return will update here