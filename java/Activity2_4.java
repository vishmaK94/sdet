package session2Activity2;

class CustomException extends Exception{
	
	private String message;
	
	public CustomException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;		
	}
}

public class Activity2_4 {
	
	public static void exceptionTest(String val) throws CustomException {
		if(val != null) {
			System.out.println(val);
		} else {
			throw new CustomException("Exception occurred! The string is null");
		}
			
	}

	public static void main(String[] args) {
			
		try {
			exceptionTest("This is a valid string");
			exceptionTest(null);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}				

	}

}
