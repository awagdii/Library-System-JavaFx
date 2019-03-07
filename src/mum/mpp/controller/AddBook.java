package mum.mpp.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.Author;
import mum.mpp.model.Book;
import mum.mpp.util.LibraryUtil;
import mum.mpp.util.ValidatorUtil;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBook implements Initializable {
    @FXML
    private JFXTextField title=new JFXTextField();
    @FXML
    private JFXTextField isbn=new JFXTextField();
    @FXML
    private JFXTextField copyCount=new JFXTextField();
    @FXML
    private ComboBox<String> checkOutDays=new ComboBox<>();

    @FXML
    CheckComboBox<String> authors=new CheckComboBox<>();


    @FXML
    protected void addBookAction(ActionEvent event) {

        if(getTitle().getText() == null || getIsbn().getText() == null
                || getCopyCount().getText().equals("")
                || getTitle().getText()==null || getIsbn().getText().equals("") || getCopyCount().getText().equals("")){

            String message="Some required Fields are missed";

            LibraryUtil.createNewAlert("Input Validation Error",message);
            return;
        }

        if(getIsbn().getText()!=null && !getIsbn().getText().equals("")){
            for(Book book: ApplicationInitialDB.books){
                if(book.getIsbn().equals(getIsbn().getText())){
                    LibraryUtil.createNewAlert("Input Validation Error","Duplicated ISBN Id, Please enter different Id");
                    return;
                }
            }
        }
        StringBuffer displayedNames=new StringBuffer("");
        if(getIsbn().getText()!=null && getCopyCount().getText()!=null ){
            if(!ValidatorUtil.isNumeric(getIsbn().getText())||!ValidatorUtil.isNumeric(getCopyCount().getText())){
                LibraryUtil.createNewAlert("Input Validation Error","ISBN , CopyCount, Check Out Days should has numeric values only");
                return;
            }
        }

        int noOfCopies=Integer.parseInt(getCopyCount().getText());
        Book book=null;
        IndexedCheckModel<String> selectedAuthors=null;

        for(int i=0;i<noOfCopies;i++) {
            if (i == 0) {
                book = new Book(Integer.toString(i), getTitle().getText(), getIsbn().getText(), Integer.parseInt(getCheckOutDays().getValue()), null);
            }else{
                book.addBookCopy(Integer.toString(i), book);
            }
            selectedAuthors = authors.getCheckModel();
            if (selectedAuthors.getCheckedItems() != null && selectedAuthors.getCheckedItems().size() <= 0) {
                LibraryUtil.createNewAlert("Validation Message", "Book should has at least one author");
                return;
            }
        }
            ArrayList<Author> authorsArrayList=new ArrayList<>();
            for(int j=0;j<selectedAuthors.getCheckedItems().size();j++){
                String selectedName=selectedAuthors.getCheckedItems().get(j);
                String[] selectedSplitted =selectedName.split(" ");
                for(Author a:ApplicationInitialDB.authors){
                    if(a.getFirstName().equals(selectedSplitted[0]) && a.getLastName().equals(selectedSplitted[1])){
                         authorsArrayList.add(a);
                        displayedNames.append(a.getFirstName()+"  "+a.getLastName()+ " ");
                    }
                }
            }

        book.setAuthorList(authorsArrayList);
        if(book!=null) {
            ApplicationInitialDB.books.add(book);
            LibraryUtil.createNewAlert("Successful action","Book was added successfully with "+noOfCopies+" selected Authors count : "+authorsArrayList.size());
        }

    }

    public JFXTextField getTitle() {
        return title;
    }

    public void setTitle(JFXTextField title) {
        this.title = title;
    }

    public JFXTextField getIsbn() {
        return isbn;
    }

    public void setIsbn(JFXTextField isbn) {
        this.isbn = isbn;
    }

    public JFXTextField getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(JFXTextField copyCount) {
        this.copyCount = copyCount;
    }

    public ComboBox<String> getCheckOutDays() {
        return checkOutDays;
    }

    public void setCheckOutDays(ComboBox<String> checkOutDays) {
        this.checkOutDays = checkOutDays;
    }

    public void initialize(URL location, ResourceBundle resources){
        String days[] =
                { "7", "21" };


        checkOutDays.getItems().clear();
        checkOutDays.getItems().addAll(days);
        checkOutDays.getSelectionModel().select(1);


        ArrayList<String> authorsList=new ArrayList<>();
        for(Author a:ApplicationInitialDB.authors){
            authorsList.add(a.getFirstName()+" "+a.getLastName());
        }

        authors.getItems().addAll(authorsList);

    }
}
