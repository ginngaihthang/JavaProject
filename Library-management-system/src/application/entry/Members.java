package application.entry;

import java.time.LocalDate;

public class Members {
	private int card_id;
	private String name;
	private int  roll_no;
	private String class_year;
	private String academic_year;
	private LocalDate register_date;
	private LocalDate expried_date;
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getClass_year() {
		return class_year;
	}
	public void setClass_year(String class_year) {
		this.class_year = class_year;
	}
	public String getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}
	public LocalDate getRegister_date() {
		return register_date;
	}
	public void setRegister_date(LocalDate register_date) {
		this.register_date = register_date;
	}
	public LocalDate getExpried_date() {
		return expried_date;
	}
	public void setExpried_date(LocalDate expried_date) {
		this.expried_date = expried_date;
	}
	
	
}
