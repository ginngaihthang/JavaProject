package application.entry;

public class Books {
	private int code;
	private String title;
	private Categories category;
	private Authors author;
	private int avaliable;
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
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	public String getAuthorName() {
		return this.author.getName();
	}
	public String getCategoryName() {
		return this.category.getName();
	}
	public int getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(int avaliable) {
		this.avaliable = avaliable;
	}
	
}
