package mum.mpp.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login extends Application {

    @FXML
    private TextField idField;
    @FXML
    private PasswordField passwdField;
    @FXML
    private Label errorLabel;

    @FXML
    public void clickLoginAction(ActionEvent event) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mum/mpp/view/login.fxml"));
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Library System");
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
