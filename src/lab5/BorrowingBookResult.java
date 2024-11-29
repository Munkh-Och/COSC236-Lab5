package lab5;

public class BorrowingBookResult {

	private boolean isSuccess = true; 
	private String borrowingMessage; 

	// Constructor 

	public BorrowingBookResult(boolean isSuccess, String borrowingMessage){ 
		this.isSuccess = isSuccess; 
		this.borrowingMessage = borrowingMessage; 

	} 
	
	// Getters and setters 
	
	public boolean getSuccessStatus() {
		return this.isSuccess;
	}
	
	public String getBorrowingMessage() {
		return this.borrowingMessage;
	}
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public void setBorrowingMessage(String message) {
		this.borrowingMessage = message;
	}
	// DONE implement getters and setters

}

