package day8;

public class Block_Data {
	static final int MIN_LENGTH;
	final int empId;
	String phone;
	public Block_Data(String phone) {
		System.out.println("this is constructor block");
		if(phone.length() >= MIN_LENGTH) {
			this.phone = phone;
			System.out.println(phone);
		}
	}
	// instance block
	{
		empId=1;
		phone = "unknown";
		System.out.println("This is instance block");
	}
	//static block
	static {
		MIN_LENGTH = 9;
		System.out.println("This is static block");
	}
	public static void main(String[] args) {
		Block_Data obj1 = new Block_Data("09256445131");
		System.out.println("-----------");
		Block_Data obj2 = new Block_Data("1233");
		
	}
}
