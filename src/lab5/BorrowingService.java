package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	// TODO: Implement methods for borrowing 
	// and returning Books 

	@Override 
	public boolean borrowBook(Member member, Book book) { 
		// Here you can implement logic to check if the book is available to 
		// borrow and if the member can borrow it  
		//(e.g., item limit, member status).  
		if(book.getIsAvailable()) {
			member.borrowBook(book);
			System.out.println("Borrowing book: " + book); 
			return true; // Return true for success 
		} 
		System.out.println("Book is not available");
		return false;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		// Implement logic to handle returning a book
		if(member.getBorrowedBooks().equals(book)) {
			member.returnBook(book);
			System.out.println("Returning book: " + book);
			return true; // Return true for success 
		}
		
		return false;
	}
}
