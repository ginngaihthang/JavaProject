package application.entry;

import java.time.LocalDate;

public class Borrows {
	private int id;
	private Members member = new Members();
	private Books book = new Books();
	private LocalDate borrow_date;
	private LocalDate due_date;
	private LocalDate return_date;
	private int fees;
	
	private Librarians created_by;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Members getMember() {
		return member;
	}
	public void setMember(Members member) {
		this.member = member;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Librarians getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Librarians created_by) {
		this.created_by = created_by;
	}
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	
	public int getCard_id() {
		return this.member.getCard_id();
	}
	public int getBook_id() {
		return this.book.getCode();
	}
	public String getTitle() {
		return this.book.getTitle();
	}
	public String getLibrianName() {
		return this.created_by.getName();
	}
}
