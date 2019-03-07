package mum.mpp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.DisplayLibraryMemberTableView;
import mum.mpp.model.LibraryMember;
import mum.mpp.model.CheckOutEntryTableView;
import mum.mpp.util.LibraryUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class DisplaylibraryMember implements Initializable {
    @FXML
	Button button=new Button();
    @FXML
    TextField libMemberId=new TextField();
	@FXML
	private TableView<DisplayLibraryMemberTableView> tbData;
	@FXML
	private TableColumn<DisplayLibraryMemberTableView, String> firstName;
	@FXML
	private TableColumn<DisplayLibraryMemberTableView, String> lastName;
	@FXML
	private TableColumn<DisplayLibraryMemberTableView, String> memberId;
	@FXML
	private TableColumn<DisplayLibraryMemberTableView, String> address;
	@FXML
	private TableColumn<DisplayLibraryMemberTableView, String> phoneNumber;

    @FXML
    public void submit(ActionEvent ae) {
	    if(libMemberId.getText()==null || libMemberId.getText().equals("")) {
	    	LibraryUtil.createNewAlert("Validation Error", "Lib member ID should be provided");
	        return;
	    }
       for(LibraryMember libM:ApplicationInitialDB.libraryMembers) {
    	   if(libM.getMemberId().equals(libMemberId.getText())) {
    		   System.out.println(libM);
    		   observableList.add(new DisplayLibraryMemberTableView(libM.getFirstName(),libM.getLastName(),libM.getMemberId(),libM.getAddress().toString(),libM.getPhoneNumber()));
    	        return;
    	   }
       }
		LibraryUtil.createNewAlert("Failed to Find Lib Member ID", "Please check provide existing Lib member id");
    	
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		tbData.setItems(observableList);
	}
	// add your data here from any source
	private ObservableList<DisplayLibraryMemberTableView> observableList = FXCollections.observableArrayList();
}
