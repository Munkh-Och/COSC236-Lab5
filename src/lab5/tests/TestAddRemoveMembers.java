package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;
import lab5.Library;
import lab5.PaperBook;
import lab5.Book;
import lab5.BorrowingService;
import lab5.EBook;

class TestAddRemoveMembers {

    private Library library;
    private BorrowingService service;
    private Member member1;
    private Member member2;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library(); // Empty library for each test
        this.service = BorrowingService.getInstance(); // Initialize BorrowingService
        this.member1 = new Member("Dude", service);
        this.member2 = new Member("Gal", service);
        this.book1 = new PaperBook("Dune");
        this.book2 = new EBook("1984");

        // Ensure books are available
        this.book1.setIsAvailable(true);
        this.book2.setIsAvailable(true);
    }

    @Test
    void AddMember() {
        assertEquals(0, library.membersCount(), "Should be no members after initialization");
        library.addMember(member1);
        assertEquals(1, library.membersCount(), "One member should have been added");
        library.addMember(member2);
        assertEquals(2, library.membersCount(), "Two members should have been added");
    }

    @Test
    void RemoveMembersMember() {
        AddMember();
        assertEquals(2, library.membersCount(), "Two members should have been in the library");
        library.removeMember(member2);
        assertEquals(1, library.membersCount(), "Only one member should remain");
    }

    @Test
    void RemoveMemberString() {
        AddMember();
        assertEquals(2, library.membersCount(), "Two members should have been in the library");
        library.removeMember("Dude");
        assertEquals(1, library.membersCount(), "Only one member should remain");
    }

    @Test
    void RemoveMemberWithBooks() {
        AddMember();
        assertEquals(2, library.membersCount(), "Two members should be in the library");
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.booksCount(), "Two books should be in the library");

        member1.borrowBook(book1);
        member1.borrowBook(book2);
        assertEquals(2, member1.borrowedBooksCount(), "Should be two borrowed books");
        assertFalse(book1.getIsAvailable(), "Book should not be available");
        assertFalse(book2.getIsAvailable(), "Book should not be available");

        library.removeMember(member1);
        assertEquals(1, library.membersCount(), "Only one member should remain");
        assertEquals(2, library.booksCount(), "Two books should be in the library");
        assertTrue(book1.getIsAvailable(), "Book should be available");
        assertTrue(book2.getIsAvailable(), "Book should be available");
    }
}
