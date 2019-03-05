package mum.mpp.model;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {

	private String title;
	private String isbn;
	private List<Author> authorList;
	private List<BookCopy> copyList;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Author> getAuthorList() {
		return authorList;
	}
	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
	public List<BookCopy> getCopyList() {
		return copyList;
	}
	public void setCopyList(List<BookCopy> copyList) {
		this.copyList = copyList;
	}
}
