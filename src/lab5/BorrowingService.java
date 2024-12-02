package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    // Singleton instance
    private static BorrowingService instance;

    private BorrowingService() {
        // Constructor is private to prevent external instantiation
    }

    public static synchronized BorrowingService getInstance() {
        if (instance == null) {
            instance = new BorrowingService();
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        BorrowingBookResult notAvailable = new BorrowingBookResult(false, "Book was not borrowed successfully.");
        BorrowingBookResult available = new BorrowingBookResult(true, "Book was borrowed successfully: " + book.getTitle());

        // Check if the book is available and if the member can borrow it
        if (!book.getIsAvailable()) {
            return notAvailable;
        }

        if (member.borrowedBooksCount() >= 3) { // Enforce borrowing limit per member
            return new BorrowingBookResult(false, "Borrowing limit reached.");
        }

        // Add the book to the member's borrowed list
        member.getBorrowedBooks().add(book);
        book.setIsAvailable(false);
        return available;
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        BorrowingBookResult success = new BorrowingBookResult(true, "Book returned successfully: " + book.getTitle());
        BorrowingBookResult unsuccess = new BorrowingBookResult(false, "Book not borrowed by the member: " + book.getTitle());

        // Check if the member has borrowed the book
        if (!member.getBorrowedBooks().contains(book)) {
            return unsuccess;
        }

        // Remove the book from the member's borrowed list
        member.getBorrowedBooks().remove(book);
        book.setIsAvailable(true);
        return success;
    }
}
