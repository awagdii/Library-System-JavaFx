package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import mum.mpp.business.ServicesImp;
import mum.mpp.model.Address;
import mum.mpp.model.Author;
import mum.mpp.util.LibraryUtil;
import mum.mpp.util.ValidatorUtil;
import mum.mpp.util.transferobj.PersonActionResult;

public class AddAuthor {

    @FXML
    private JFXTextField bio;
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
    private JFXButton saveButton;


    ServicesImp services = ServicesImp.getServicesImp();

    @FXML
    protected void clickSave(ActionEvent event) {

        if(bio.getText() == null || firstNameField.getText() == null || lastNameField.getText()==null
                || bio.getText().equals("")
                || phoneField.getText()==null || lastNameField.getText().equals("") || firstNameField.getText().equals("") || phoneField.getText().equals("")){

            String message="Some required Fields are missed";

            LibraryUtil.createNewAlert("Input Validation Error",message);
            return;
        }
        if(phoneField.getText()!=null){
            if(!ValidatorUtil.isNumeric(phoneField.getText())){
                LibraryUtil.createNewAlert("Input Validation Error","Phone Number should has numeric values only");
                return;
            }
        }
        Author author = new Author();
        author.setBio(bio.getText());
        author.setFirstName(firstNameField.getText());
        author.setLastName(lastNameField.getText());
        author.setPhoneNumber(phoneField.getText());
        Address address = new Address();
        address.setCity(cityField.getText());
        address.setState(stateField.getText());
        address.setStreet(streetField.getText());
        address.setZip(zipField.getText());
        author.setAddress(address);

        services.addAuthor(author);
        LibraryUtil.createNewAlert("Action Done","New Author was added successfully");

        bio.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        cityField.setText("");
        stateField.setText("");
        streetField.setText("");
        zipField.setText("");
    }

}
