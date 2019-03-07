package mum.mpp.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.Author;
import mum.mpp.model.Book;
import mum.mpp.model.LibraryMember;
import mum.mpp.util.LibraryUtil;
import mum.mpp.util.ValidatorUtil;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;

import java.util.ArrayList;
import java.util.List;

public class AddBook {
    private JFXTextField title;
    private JFXTextField isbn;
    private JFXTextField copyCount;
    private JFXTextField checkOutDays;

    @FXML
    protected void addBookAction(ActionEvent event) {

        if(title.getText() == null || isbn.getText() == null || checkOutDays.getText()==null
                || copyCount.getText().equals("")
                || title.getText()==null || isbn.getText().equals("") || checkOutDays.getText().equals("") || copyCount.getText().equals("")){

            String message="Some required Fields are missed";

            LibraryUtil.createNewAlert("Input Validation Error",message);
            return;
        }

        if(isbn.getText()!=null && !isbn.getText().equals("")){
            for(Book book: ApplicationInitialDB.books){
                System.out.println(book.getIsbn()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+isbn.getText());
                if(book.getIsbn().equals(isbn.getText())){
                    LibraryUtil.createNewAlert("Input Validation Error","Duplicated ISBN Id, Please enter different Id");
                    return;
                }
            }
        }
        if(isbn.getText()!=null &&copyCount.getText()!=null &&checkOutDays.getText()!=null ){
            if(!ValidatorUtil.isNumeric(isbn.getText())||!ValidatorUtil.isNumeric(copyCount.getText()) &&!ValidatorUtil.isNumeric(checkOutDays.getText()) ){
                LibraryUtil.createNewAlert("Input Validation Error","ISBN , CopyCount, Check Out Days should has numeric values only");
                return;
            }
        }

//        int noOfCopies=Integer.parseInt(copyCount.getText());
//        Book book;
//        for(int i=0;i<=noOfCopies;i++) {
//            if(i==0) {
//               book= new Book(i,title.getText(),isbn.getText(),checkOutDays.getText(),null);
//            }
//        }

    }

}
