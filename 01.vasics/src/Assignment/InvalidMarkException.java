package Assignment;

public class InvalidMarkException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public InvalidMarkException(String msg) {
		super(msg);
	}
	public InvalidMarkException(){
	}
}