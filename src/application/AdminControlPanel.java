package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AdminControlPanel implements Initializable {
	
	@FXML
	private ComboBox<String> optionalAdminActions;

	@FXML
	private Button procceedForSelectedAction;

	@FXML
	Hyperlink  signOut;
	
	public void submit(ActionEvent ae) {
	//	Alert a=new Alert(AlertType.INFORMATION);
//		if(tf.getText().equals("Hesham") && pf.getText().equals("test")) {
//			System.out.println("Success !");
//			a.setContentText("Successful");
//		    a.show();
//		}else {
//			System.out.println("Fail !");
//			a.setContentText("Login Failure");
//			a.show();
//		}
	}

	public void signOut(ActionEvent ae) {
		//	Alert a=new Alert(AlertType.INFORMATION);
//			if(tf.getText().equals("Hesham") && pf.getText().equals("test")) {
//				System.out.println("Success !");
//				a.setContentText("Successful");
//			    a.show();
//			}else {
//				System.out.println("Fail !");
//				a.setContentText("Login Failure");
//				a.show();
//			}
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		    List<String> list = new ArrayList<String>();
	        list.add("Add librarian");
	        list.add("Update librarian");
	        list.add("Add Book");
	        list.add("Add Book Copies");
	        
	        ObservableList<String> obList = FXCollections.observableList(list);
	        optionalAdminActions.getItems().clear();
	        optionalAdminActions.setItems(obList);
	        optionalAdminActions.getSelectionModel().select(0);
	}
	
}
