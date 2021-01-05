package session2Activity2;

abstract class Book{
	String title;
	
	abstract public void setTitle(String title);
	
	public String getTitle() {
		return this.title;
	}
}

class MyBook extends Book {

	@Override
	public void setTitle(String title) {
		this.title = title;		
	}
	
}

public class Activity2_1 {

	public static void main(String[] args) {

		MyBook newNovel = new MyBook();
		
		newNovel.setTitle("Meluha");
		System.out.println("The title of book is : "+newNovel.getTitle());

	}

}
