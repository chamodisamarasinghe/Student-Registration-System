package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;

public class StudentFormController {
    public AnchorPane studentFormContext;
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtAddress;
    public TextField txtAge;
    public TableView<StudentTM> tblStudent;
    public ComboBox cmbGender;
    public TextField txtId;
    public TextField txtGender;
    public TableColumn colId;
    public TableColumn colNIC;
    public TableColumn colName;
    public TableColumn colGender;
    public TableColumn colBirthday;
    public TableColumn colAge;
    public TableColumn colAddress;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAddNew;
    public TextField txtBirthday;

    public void initialize(){
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("NIC"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("birthday"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("age"));
        tblStudent.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("address"));
        initUI();

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnAdd.setText(newValue != null ? "Update" : "Save");
            btnAdd.setDisable(newValue == null);
            if (newValue != null) {
                txtId.setText(newValue.getStudentId());
                txtNIC.setText(newValue.getNIC());
                txtName.setText(newValue.getName());
                txtGender.setText(newValue.getGender());
                txtBirthday.setText(newValue.getBirthday());
                txtAge.setText(newValue.getAge());
                txtAddress.setText(newValue.getAddress());
                txtId.setDisable(false);
                txtNIC.setDisable(false);
                txtName.setDisable(false);
                txtGender.setDisable(false);
                txtBirthday.setDisable(false);
                txtAge.setDisable(false);
                txtAddress.setDisable(false);

            }
        });
        txtAddress.setOnAction(event -> btnAdd.fire());
        loadAllStudents();
    }

    private void loadAllStudents() {
    }

    private void initUI() {
    }

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addNewOnAction(ActionEvent actionEvent) {
    }
}
