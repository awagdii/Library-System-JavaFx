package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mum.mpp.business.IServices;
import mum.mpp.business.ServicesImp;
import mum.mpp.model.Authorizable;
import mum.mpp.model.LibraryMemberAuthorization;
import mum.mpp.util.LibraryUtil;

import java.io.IOException;


public class Login extends Application {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginButton;
    @FXML
    private Label errorLabel;

    private static IServices services = ServicesImp.getServicesImp();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mum/mpp/view/login.fxml"));
        Scene scene = new Scene(root, 750, 500);
        primaryStage.setTitle("Library System");
        scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void submit(ActionEvent ae) {

        String usernameInput, passInput;
        usernameInput = username.getText();
        passInput = password.getText();


        if(usernameInput == null || passInput == null || usernameInput.equals("") || passInput.equals("")){
            LibraryUtil.createNewAlert("Input Validation Error","UserName and Password are required!!");
            return;
        }

        Authorizable result = services.login(usernameInput, passInput);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Confirmation");

        if (result != null) {
            try {
                if (result.getAuthorization() == LibraryMemberAuthorization.BOTH) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mum/mpp/view/superAdmin.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Super Admin Page");
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();
                } else if (result.getAuthorization() == LibraryMemberAuthorization.ADMIN) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mum/mpp/view/admin.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Admin Page");
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();
                } else if (result.getAuthorization() == LibraryMemberAuthorization.LIBRARIAN) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mum/mpp/view/checkOutBook.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Library Member Page");
                    stage.setScene(new Scene(fxmlLoader.load()));
                    stage.show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            loginButton.getScene().getWindow().hide();

        } else {
            alert.setContentText("Login Failed");
            alert.showAndWait();
        }

    }

}
