package day11.abstraction;

public class Demo {
	public static void main(String[] args) {
		ProductServive p_service = new ProductServive();
		p_service.connectDatabase();
		p_service.insert();
		p_service.update();
		p_service.delete(1);
		p_service.findById(10);
		
	}
}
