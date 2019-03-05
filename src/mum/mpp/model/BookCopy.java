package mum.mpp.model;

import java.io.Serializable;

public class BookCopy implements Serializable {
	private String copyId;

	public String getCopyId() {
		return copyId;
	}

	public void setCopyId(String copyId) {
		this.copyId = copyId;
	}
}
