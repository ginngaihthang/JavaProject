package com.mmit.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {
	private int code;
	private String title;
	private int price;
	private LocalDate publist_date;
	private Category  cateogry = new Category();
	private Author author = new Author();
	private LocalDateTime cteated_at;
	private LocalDateTime updated_at;
	private User created_by = new User();
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPublist_date() {
		return publist_date;
	}
	public void setPublist_date(LocalDate publist_date) {
		this.publist_date = publist_date;
	}
	public Category getCateogry() {
		return cateogry;
	}
	public void setCateogry(Category cateogry) {
		this.cateogry = cateogry;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public LocalDateTime getCteated_at() {
		return cteated_at;
	}
	public void setCteated_at(LocalDateTime cteated_at) {
		this.cteated_at = cteated_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	
	public String getAuthorName() {
		return this.author.getName();
	}
	public String getCategoryName() {
		return this.cateogry.getName();
	}
	public String getUserName() {
		return this.created_by.getName();
	}
}
