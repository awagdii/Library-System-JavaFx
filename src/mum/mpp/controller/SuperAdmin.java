package mum.mpp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mum.mpp.business.ServicesImp;
import mum.mpp.model.Author;

import java.util.ArrayList;

public class SuperAdmin {


    @FXML
    protected void clickSave(ActionEvent event) {
        ArrayList<String> authorsList = new ArrayList<>();
        for (Author a : ServicesImp.getServicesImp().getAuthors()) {
            authorsList.add(a.getFirstName() + " " + a.getLastName());
        }


    }
}