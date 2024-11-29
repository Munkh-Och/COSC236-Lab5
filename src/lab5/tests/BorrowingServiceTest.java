package lab5.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.EBook;
import lab5.Member;
import lab5.Book;

public class BorrowingServiceTest {
	@Test
    public void testBorrowBook() {
        Member member = new Member("Alice");
        Book book = new EBook("The Great Gatsby");
        BorrowingService service = new BorrowingService();

        // Test borrowing a book
        assertTrue(service.borrowBook(member, book));
        assertTrue(member.getBorrowedBooks().contains(book));

        // Test borrowing the same book again
        assertFalse(service.borrowBook(member, book));
    }
	
	@Test
    public void testReturnBook() {
        Member member = new Member("Alice");
        Book book = new EBook("The Great Gatsby");
        BorrowingService service = new BorrowingService();

        // Borrow the book first
        service.borrowBook(member, book);

        // Test returning the book
        assertTrue(service.returnBook(member, book));
        assertFalse(member.getBorrowedBooks().contains(book));

        // Test returning a book not borrowed
        assertFalse(service.returnBook(member, book));
    }
}
