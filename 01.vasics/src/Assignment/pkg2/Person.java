package Assignment.pkg2;

public class Person {
	String name;
	String nrc;
	String address;
	String phone;
	Person() {
		
	}
	Person(String name, String nrc, String address, String phone) {
		this.name = name;
		this.nrc = nrc;
		this.address = address;
		this.phone = phone;
		
	}
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}
	
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getNrc() {
		return nrc;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	void showInfo() {
		System.out.println("Name\t" + "NRCNO\t\t" + "Address\t" + "Phone");
		System.out.println(name + "\t" + nrc + "\t" + address + "\t" + phone );
	}
	void showIdentificationInfo() {
		String[] division = {"AA" ,"BB" ,"CC" ,"DD" ,"EE" ,"FF", "GG", "HH" ,"II" ,"JJ" ,"KK" ,"LL" ,"MM" ,"NN"};
		String[] splits = nrc.split("\\/");
		String[] splits1 = nrc.split("\\(");
		String[] splits2 = nrc.split("\\)");
		String[] splits3 = splits1[0].split("\\/");
		for(int i =0; i < division.length; i++ ) {
			if(Integer.parseInt(splits[0]) == i+1) {
				System.out.println("\nDivision/state =" + division[i]);
				System.out.println("Township -> " + splits3[1]);
				System.out.println("Nrc number ->" + splits2[1]);			
			}
			
		}
	}
}
