package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Book implements Serializable {


	public Book(String copyId,String title,String isbn,int avaiableCount,int borrowModel,ArrayList<Author> authors){ this.authorList=authors;
       this.avaiableCount=avaiableCount;
       this.borrowModel =borrowModel;
       this.isbn=isbn;
       this.title=title;
       addBookCopy(copyId,this);
	}

	private String title;
	private String isbn;

	private int avaiableCount=1;

	private int borrowModel=21;  //this may be 7 or 21 DAYS

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




	public void addBookCopy(String copyId, Book book){
		copyList.add(new BookCopy(copyId, this));
	}


	public int getAvaiableCount() {
		return avaiableCount;
	}

	public void setAvaiableCount(int avaiableCount) {
		this.avaiableCount = avaiableCount;
	}

	public int getBorrowModel() {
		return borrowModel;
	}

	public void setBorrowModel(int borrowModel) {
		this.borrowModel = borrowModel;
	}
}
