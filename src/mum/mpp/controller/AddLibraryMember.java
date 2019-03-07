package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import mum.mpp.business.IServices;
import mum.mpp.business.ServicesImp;
import mum.mpp.model.Address;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.LibraryMember;
import mum.mpp.util.LibraryUtil;
import mum.mpp.util.ValidatorUtil;
import mum.mpp.util.transferobj.PersonActionResult;

import java.net.URL;
import java.util.ResourceBundle;

public class AddLibraryMember implements Initializable {
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


    IServices services = new ServicesImp();

    @FXML
    protected void clickSave(ActionEvent event) {

        if(idField.getText() == null || firstNameField.getText() == null || lastNameField.getText()==null
                || idField.getText().equals("")
                || phoneField.getText()==null || lastNameField.getText().equals("") || firstNameField.getText().equals("") || phoneField.getText().equals("")){

            String message="Some required Fields are missed";

            LibraryUtil.createNewAlert("Input Validation Error",message);
            return;
        }

        if(idField.getText()!=null && !idField.getText().equals("")){
            for(LibraryMember lm:ApplicationInitialDB.libraryMembers){
                System.out.println(lm.getMemberId()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+idField.getText());
                if(lm.getMemberId().equals(idField.getText())){
                    LibraryUtil.createNewAlert("Input Validation Error","Duplicated Membership Id, Please enter different Id");
                    return;
                }
            }
        }
        if(phoneField.getText()!=null){
            if(!ValidatorUtil.isNumeric(phoneField.getText())){
                LibraryUtil.createNewAlert("Input Validation Error","Phone Number should has numeric values only");
                return;
            }
        }


        mum.mpp.model.LibraryMember libraryMember = new mum.mpp.model.LibraryMember(idField.getText());
        libraryMember.setFirstName(firstNameField.getText());
        libraryMember.setLastName(lastNameField.getText());
        libraryMember.setPhoneNumber(phoneField.getText());
        Address address = new Address();
        address.setCity(cityField.getText());
        address.setState(stateField.getText());
        address.setStreet(streetField.getText());
        address.setZip(zipField.getText());
        libraryMember.setAddress(address);





        PersonActionResult par = services.addLibraryMember(libraryMember);
        if (par.isResult()) {
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
