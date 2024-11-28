package lab5;

public class AudioBook implements Book {
	private String title;
	private boolean isAvailable;
	
	public AudioBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	
	@Override
	public void setIsAvailable(boolean isAvailable) {
		// TODO Auto-generated method stub
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean getIsAvailable() {
		// TODO Auto-generated method stub
		return isAvailable;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	@Override
	public String toString() {
		return "Ebook " + title;
	}
}
