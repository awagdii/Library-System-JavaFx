package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import mum.mpp.business.IServices;
import mum.mpp.business.ServicesImp;
import mum.mpp.model.Address;
import mum.mpp.util.transferobj.PersonActionResult;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryMember implements Initializable {
    @FXML
    private JFXTextField idField;
    @FXML
    private JFXTextField firstNameField;
    @FXML
    private JFXTextField lastNameField;
    @FXML
    private JFXTextField streetField;
    @FXML
    private JFXTextField cityField;
    @FXML
    private JFXTextField stateField;
    @FXML
    private JFXTextField zipField;
    @FXML
    private JFXTextField phoneField;
    @FXML
    private JFXComboBox comboBox;
    @FXML
    private JFXButton saveButton;


    IServices services=new ServicesImp();

    @FXML
    protected void clickSave(ActionEvent event) {
        mum.mpp.model.LibraryMember libraryMember = new mum.mpp.model.LibraryMember();
        libraryMember.setFirstName(firstNameField.getText());
        libraryMember.setLastName(lastNameField.getText());
        libraryMember.setPhoneNumber(phoneField.getText());
        libraryMember.setMemberId(idField.getText());
        Address address=new Address();
        address.setCity(cityField.getText());
        address.setState(stateField.getText());
        address.setStreet(streetField.getText());
        address.setZip(zipField.getText());
        libraryMember.setAddress(address);
        PersonActionResult par=services.addLibraryMember(libraryMember);
        if(par.isResult()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Library Member added successfully");
            alert.setContentText(par.getActionMessage());
            alert.show();
        }
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        idField.setText("");
        cityField.setText("");
        stateField.setText("");
        streetField.setText("");
        zipField.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData() {
        comboBox.getItems().clear();
        comboBox.getItems().addAll("Librarian", "Admin", "Both");
        comboBox.setValue("Librarian");
    }
}
