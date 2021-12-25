package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInFormController {
    public AnchorPane logInFormContext;
    public JFXTextField txtUserName;
    public JFXTextField txtPassWord;

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("Manager") && txtPassWord.getText().equals("123")) {
            Stage window = (Stage) logInFormContext.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBoardForm.fxml"))));

        } else {
            new Alert(Alert.AlertType.WARNING, "Incorrect User Name, Password. Try again..", ButtonType.CLOSE).show();
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {

    }
}
