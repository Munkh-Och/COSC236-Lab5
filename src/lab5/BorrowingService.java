package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	// TODO: Implement methods for borrowing 
	// and returning Books 

	@Override 
	public boolean borrowBook(Member member, Book book) { 
		// Here you can implement logic to check if the book is available to 
		// borrow and if the member can borrow it  
		//(e.g., item limit, member status).  
		if(!book.getIsAvailable()){
			System.out.println("Book is not available");
			return false; // Return true for failure
		} 
		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		System.out.println("Book borrowed successfully: " + book);
		return true;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		// Implement logic to handle returning a book
		if(!member.getBorrowedBooks().contains(book)) {
			System.out.println("Cannot return: Book not borrowed by the member.");
			return false; // Return true for failure
		}
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		System.out.println("Book returned successfully: " + book);
        return true;
	}
}
