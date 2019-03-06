package application;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import mum.mpp.controller.Login;
import mum.mpp.util.SplashScreenLoader;
import mum.mpp.model.ApplicationInitialDB;


public class Main extends Application {
    public static void main(String[] args) {
        ApplicationInitialDB.prepareSomeInitialData();
        ApplicationInitialDB.loadInitialDB();
        LauncherImpl.launchApplication(Login.class, SplashScreenLoader.class, args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
