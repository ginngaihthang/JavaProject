package day11.abstraction;

public class ProductServive extends DatabaseUtil {

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert into product valud(?,?,?)");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("update product set price = ?");
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("Delete form product WHERE id " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Select * form product where id = " + id);
		return null;
	}

	
}
