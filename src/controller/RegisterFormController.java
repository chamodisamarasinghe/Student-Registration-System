package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class RegisterFormController {
    public AnchorPane registerFormContext;
    public Label lblDate;
    public Label lblTime;
    public ComboBox cmbStudentId;
    public TextField txtNIC;
    public TextField txtName;
    public TextField txtGender;
    public TextField txtBirthday;
    public TextField txtAge;
    public TextField txtAddress;
    public ComboBox cmbProgrammeId;
    public TextField txtProgramme;
    public TextField txtDuration;
    public TextField txtFee;
    public TableView tblRegistration;
    public Label lblTotal;


    public void initialize(){

    }

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) registerFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
