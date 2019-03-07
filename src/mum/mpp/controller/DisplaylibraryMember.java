package mum.mpp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.LibraryMember;
import mum.mpp.util.LibraryUtil;

public class DisplaylibraryMember {
    @FXML
	Button button=new Button();
    @FXML
    TextField libMemberId=new TextField();
    @FXML
    public void submit(ActionEvent ae) {
	    if(libMemberId.getText()==null || libMemberId.getText().equals("")) {
	    	LibraryUtil.createNewAlert("Validation Error", "Lib member ID should be provided");
	        return;
	    }
       for(LibraryMember libM:ApplicationInitialDB.libraryMembers) {
    	   if(libM.getMemberId().equals(libMemberId.getText())) {
    		   System.out.println(libM);
    			LibraryUtil.createNewAlert("Action Done successfully", "Please check Your Console");
    	        return; 
    	   }
       }
		LibraryUtil.createNewAlert("Failed to Find Lib Member ID", "Please check provide existing Lib member id");
    	
    }
    
}
