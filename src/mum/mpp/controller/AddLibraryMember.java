package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

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

    @FXML
    protected void clickSave(ActionEvent event) {
        System.out.println("click save");
        String roleValue = (String)comboBox.getValue();
        System.out.println("role; " + roleValue);
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
