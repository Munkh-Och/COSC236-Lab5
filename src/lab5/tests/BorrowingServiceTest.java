package lab5.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.EBook;
import lab5.Member;
import lab5.Book;
import lab5.BorrowingBookResult;

public class BorrowingServiceTest {
	@Test
	public void testBorrowBookFailures() {
        Member member = new Member("Alice");
        Book book = new EBook("The Great Gatsby");
        BorrowingService service = new BorrowingService();

        // Borrow the book successfully
        BorrowingBookResult result1 = service.borrowBook(member, book);
        assertTrue(result1.getSuccessStatus());
        assertEquals("Book was borrowed successfully " + book.getTitle(), result1.getBorrowingMessage());

        // Attempt to borrow the same book again
        BorrowingBookResult result2 = service.borrowBook(member, book);
        assertFalse(result2.getSuccessStatus());
        assertEquals("Book was not borrowed successfully ", result2.getBorrowingMessage());

        // Borrow books up to the limit
        service.borrowBook(member, new EBook("Book 1"));
        service.borrowBook(member, new EBook("Book 2"));
        BorrowingBookResult result3 = service.borrowBook(member, new EBook("The Great Gatsby"));
        assertFalse(result3.getSuccessStatus());
        assertEquals("Book was not borrowed successfully ", result3.getBorrowingMessage());
	}
	
	
}
