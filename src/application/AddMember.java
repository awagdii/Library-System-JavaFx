package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mum.mpp.controller.AddMemberController;

public class AddMember extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mum/mpp/view/AddMember.fxml"));
        Parent root = loader.load();

        AddMemberController controller = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Set Data to FXML through controller
        controller.setData();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
