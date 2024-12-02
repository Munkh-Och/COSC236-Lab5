package lab5.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import lab5.BookFactory;
import lab5.PaperBookFactory;
import lab5.EBookFactory;
import lab5.AudioBookFactory;
import lab5.Book;
import lab5.EBook;
import lab5.AudioBook;
import lab5.PaperBook;
class FactoryTest {

    private BookFactory paperBookFactory;
    private BookFactory eBookFactory;
    private BookFactory audioBookFactory;

    @BeforeEach
    void setUp() {
        paperBookFactory = new PaperBookFactory();
        eBookFactory = new EBookFactory();
        audioBookFactory = new AudioBookFactory();
    }

    @Test
    void testPaperBookFactoryCreatesPaperBook() {
        Book book = paperBookFactory.createBook("Moby Dick");

        assertNotNull(book, "Factory should create a book object");
        assertTrue(book instanceof PaperBook, "Created book should be an instance of PaperBook");
        assertEquals("Moby Dick", book.getTitle(), "Book title should match the input title");
    }

    @Test
    void testEBookFactoryCreatesEBook() {
        Book book = eBookFactory.createBook("Dune");

        assertNotNull(book, "Factory should create a book object");
        assertTrue(book instanceof EBook, "Created book should be an instance of EBook");
        assertEquals("Dune", book.getTitle(), "Book title should match the input title");
    }

    @Test
    void testAudioBookFactoryCreatesAudioBook() {
        Book book = audioBookFactory.createBook("1984");

        assertNotNull(book, "Factory should create a book object");
        assertTrue(book instanceof AudioBook, "Created book should be an instance of AudioBook");
        assertEquals("1984", book.getTitle(), "Book title should match the input title");
    }

    @Test
    void testUnsupportedFactoryReturnsNull() {
        // Simulate an unsupported factory
        BookFactory unsupportedFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return null; // No valid book type created
            }
        };

        Book book = unsupportedFactory.createBook("Unknown Book");
        assertNull(book, "Unsupported factory should not create a book object");
    }

    @Test
    void testFactoryWithEmptyTitle() {
        Book book = paperBookFactory.createBook("");

        assertNotNull(book, "Factory should create a book object even with an empty title");
        assertEquals("", book.getTitle(), "Book title should match the input (even if empty)");
        assertTrue(book instanceof PaperBook, "Created book should still be an instance of PaperBook");
    }

    @Test
    void testFactoryWithNullTitle() {
        Book book = eBookFactory.createBook(null);

        assertNotNull(book, "Factory should create a book object even with a null title");
        assertNull(book.getTitle(), "Book title should be null");
        assertTrue(book instanceof EBook, "Created book should still be an instance of EBook");
    }
}
