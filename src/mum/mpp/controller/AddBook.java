package mum.mpp.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import mum.mpp.business.ServicesImp;
import mum.mpp.dao.ApplicationInitialDB;
import mum.mpp.model.Author;
import mum.mpp.model.Book;
import mum.mpp.util.LibraryUtil;
import mum.mpp.util.ValidatorUtil;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

public class AddBook implements Initializable {
    @FXML
    private JFXTextField title = new JFXTextField();
    @FXML
    private JFXTextField isbn = new JFXTextField();
    @FXML
    private JFXTextField copyCount = new JFXTextField();
    @FXML
    private ComboBox<String> checkOutDays = new ComboBox<>();

    @FXML
    CheckComboBox<String> authors = new CheckComboBox<>();


    private ServicesImp serviceImp=ServicesImp.getServicesImp();




    @FXML
    protected void addBookAction(ActionEvent event) {

        if (getTitle().getText() == null || getIsbn().getText() == null
                || getCopyCount().getText().equals("")
                || getTitle().getText() == null || getIsbn().getText().equals("") || getCopyCount().getText().equals("")) {

            String message = "Some required Fields are missed";

            LibraryUtil.createNewAlert("Input Validation Error", message);
            return;
        }

        if (getIsbn().getText() != null && !getIsbn().getText().equals("")) {
                if (ValidatorUtil.isNotUniqueISBN(getIsbn().getText())) {
                    LibraryUtil.createNewAlert("Input Validation Error", "Duplicated ISBN Id, Please enter different Id");
                    return;
                }
        }
        StringBuffer displayedNames = new StringBuffer("");
        if (getIsbn().getText() != null && getCopyCount().getText() != null) {
            if (!ValidatorUtil.isNumeric(getIsbn().getText()) || !ValidatorUtil.isNumeric(getCopyCount().getText())) {
                LibraryUtil.createNewAlert("Input Validation Error", "ISBN , CopyCount, Check Out Days should has numeric values only");
                return;
            }
        }

        int noOfCopies = Integer.parseInt(getCopyCount().getText());
        Book book = null;
        IndexedCheckModel<String> selectedAuthors = null;

        for (int i = 0; i < noOfCopies; i++) {
            if (i == 0) {
                book = new Book(UUID.randomUUID().toString(), getTitle().getText(), getIsbn().getText(), Integer.parseInt(getCheckOutDays().getValue()), null);
            } else {
                book.addBookCopy(UUID.randomUUID().toString(), book);
            }
            selectedAuthors = authors.getCheckModel();
            if (selectedAuthors.getCheckedItems() != null && selectedAuthors.getCheckedItems().size() <= 0) {
                LibraryUtil.createNewAlert("Validation Message", "Book should has at least one author");
                return;
            }
        }
        ArrayList<Author> authorsArrayList = new ArrayList<>();
        for (int j = 0; j < selectedAuthors.getCheckedItems().size(); j++) {
            String selectedName = selectedAuthors.getCheckedItems().get(j);
            String[] selectedSplitted = selectedName.split(" ");
            for (Author a : serviceImp.getAuthors()) {
                if (a.getFirstName().equals(selectedSplitted[0]) && a.getLastName().equals(selectedSplitted[1])) {
                    authorsArrayList.add(a);
                    displayedNames.append(a.getFirstName() + "  " + a.getLastName() + " ");
                }
            }
        }

        book.setAuthorList(authorsArrayList);
        if (book != null) {
            serviceImp.addBook(book);
            LibraryUtil.createNewAlert("Successful action", "Book was added successfully with " + noOfCopies + "copies and selected Authors count : " + authorsArrayList.size());
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

    public void initialize(URL location, ResourceBundle resources) {
        authors.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {

                ArrayList<String> authorsList = new ArrayList<>();
                for (Author a : serviceImp.getAuthors()) {
                    authorsList.add(a.getFirstName() + " " + a.getLastName());
                    System.out.println(a.getFirstName()+"???????????????????????");
                }
                authors.getItems().clear();
                authors.getItems().addAll(authorsList);

            }

        });
        String days[] =
                {"7", "21"};


        checkOutDays.getItems().clear();
        checkOutDays.getItems().addAll(days);
        checkOutDays.getSelectionModel().select(1);


        ArrayList<String> authorsList = new ArrayList<>();
        for (Author a : serviceImp.getAuthors()) {
            authorsList.add(a.getFirstName() + " " + a.getLastName());
        }

        authors.getItems().addAll(authorsList);

    }
}
