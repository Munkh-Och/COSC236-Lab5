package lab5.tests;
import lab5.BookFactory;
import lab5.BookFactory;
import lab5.PaperBookFactory;
import lab5.EBookFactory;
import lab5.AudioBookFactory;
import lab5.Book;
import lab5.PaperBook;
import lab5.EBook;
import lab5.AudioBook;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create the factories
        BookFactory paperFactory = new PaperBookFactory();
        BookFactory eBookFactory = new EBookFactory();
        BookFactory audioFactory = new AudioBookFactory();

        // Create books using factories
        Book paperBook = paperFactory.createBook("Moby Dick");
        Book eBook = eBookFactory.createBook("Dune");
        Book audioBook = audioFactory.createBook("1984");

        // Test type of created objects
        assert paperBook instanceof PaperBook : "PaperBook creation failed";
        assert eBook instanceof EBook : "EBook creation failed";
        assert audioBook instanceof AudioBook : "AudioBook creation failed";

        // Test object properties
        assert paperBook.getTitle().equals("Moby Dick") : "Incorrect title for PaperBook";
        assert eBook.getTitle().equals("Dune") : "Incorrect title for EBook";
        assert audioBook.getTitle().equals("1984") : "Incorrect title for AudioBook";

        System.out.println("All tests passed!");
    }
}
