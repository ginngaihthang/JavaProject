package Assignment.pkg1;

public class Student {
	int studentID;
	String name;
	int mark;
	Student() {
		
	}
	Student(int StudentID, String name, int mark) {
		this.studentID = StudentID;
		this.name = name;
		this.mark = mark;
	}
	void setStudent(int Studentid)  {
		this.studentID = Studentid;
	}
	int getStudent() {
		return studentID;
	}
	
	void setName(String name) {
		this.name =name;
	}
	String getName() {
		return name;
	}
	
	void setMark(int mark) {
		if(mark < 0 || mark > 100) {
			System.out.println("Mark is invalid!");
		}
		else {
			this.mark = mark;
		}
	}
	int getMark() {
		return mark;
	}
	
	void Display() {
		
		System.out.println(studentID + "\t" + name + "\t" + mark );
	}
	boolean FindStudentWithID(int _id) {
		if(this.studentID == _id) {
			return true;
		}
		else {
			return false;
		}
	}
}
