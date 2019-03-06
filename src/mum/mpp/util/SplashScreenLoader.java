/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.mpp.util;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shall
 */
public class SplashScreenLoader extends Preloader {

    private Stage splashScreen;

    @Override
    public void start(Stage stage) throws Exception {
        splashScreen = stage;
        splashScreen.setScene(new Scene(new SplashScreen()));
        splashScreen.initStyle(StageStyle.UNDECORATED);
        splashScreen.show();
    }

    public Scene createScene() {
        StackPane root = new StackPane();
        Scene scene = new Scene(new SplashScreen(), 300, 200);
        return scene;
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
            splashScreen.hide();
        }
    }
}
