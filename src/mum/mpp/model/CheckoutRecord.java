package mum.mpp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CheckoutRecord implements Serializable {

private ArrayList<CheckoutEntry> checkOutEntries=new ArrayList<>();

public ArrayList<CheckoutEntry> getCheckOutEntries() {
	return checkOutEntries;
}

public void setCheckOutEntries(ArrayList<CheckoutEntry> checkOutEntries) {
	this.checkOutEntries = checkOutEntries;
}

	
}
