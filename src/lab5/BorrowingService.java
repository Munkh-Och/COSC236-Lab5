package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	// TODO: Implement methods for borrowing 
	// and returning Books 

	private int borrowingLimit = 3;

	@Override 
	public BorrowingBookResult borrowBook(Member member, Book book) { 
		// Here you can implement logic to check if the book is available to 
		// borrow and if the member can borrow it  
		//(e.g., item limit, member status).  

		BorrowingBookResult notAvailable = new BorrowingBookResult(false, "Book was not borrowed successfully ");
		BorrowingBookResult available = new BorrowingBookResult(true, "Book was borrowed successfully " + book.getTitle());

		if(borrowingLimit == 0 || !book.getIsAvailable()){
			return notAvailable;
		} 

		member.getBorrowedBooks().add(book);
		borrowingLimit--; //Decreases the limit
		book.setIsAvailable(false);
		return available;

	}


	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		BorrowingBookResult success = new BorrowingBookResult(true, "Book returned successfully: " + book.getTitle());
		BorrowingBookResult unsuccess = new BorrowingBookResult(false, "Book not borrowed by the member." + book.getTitle());

		// Implement logic to handle returning a book
		if(!member.getBorrowedBooks().contains(book)) {
			return unsuccess; // Return true for failure
		}
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return success;
	}
}
