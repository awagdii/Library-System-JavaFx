package application;

import mum.mpp.controller.Login;
import mum.mpp.util.transferobj.ApplicationInitialDB;


public class Main extends Login {
    public static void main(String[] args) {
        ApplicationInitialDB.prepareSomeInitialData();
        ApplicationInitialDB.loadInitialDB();
        launch(args);
    }
}
