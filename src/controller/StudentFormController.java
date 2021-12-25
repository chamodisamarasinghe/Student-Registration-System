package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StudentFormController {
    public AnchorPane studentFormContext;
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtAddress;
    public TextField txtAge;
    public TableView tblStudent;
    public ComboBox cmbGender;
    public TextField txtId;
    public TextField txtGender;

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }


}
