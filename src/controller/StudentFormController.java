package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentFormController {
    private final StudentBO studentBO = BoFactory.getBoFactory().getBO(BoFactory.BoTypes.STUDENT);
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
                txtAge.setText(String.valueOf(newValue));
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

        cmbGender.getItems().addAll("Male", "Female");
        cmbGender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue);
            System.out.println(newValue);
            txtGender.setText(String.valueOf(newValue));
        });
    }

    private void loadAllStudents() {
        tblStudent.getItems().clear();
        ArrayList<StudentDTO> allStudents = studentBO.getAllStudents();
        for (StudentDTO student : allStudents) {
            tblStudent.getItems().add(new StudentTM(student.getStudentId(), student.getNIC(), student.getName(),
                    student.getGender(), student.getBirthday(), student.getAge(), student.getAddress()));
        }

    }

    private void initUI() {
        txtId.clear();
        txtNIC.clear();
        txtName.clear();
        txtGender.clear();
        txtBirthday.clear();
        txtAge.clear();
        txtAddress.clear();
        txtId.setDisable(false);
        txtNIC.setDisable(false);
        txtName.setDisable(false);
        txtGender.setDisable(false);
        txtBirthday.setDisable(false);
        txtAge.setDisable(false);
        txtAddress.setDisable(false);
        txtId.setEditable(true);
        btnAdd.setDisable(false);
        btnDelete.setDisable(true);
    }

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addOnAction(ActionEvent actionEvent) throws Exception {

        String studentId = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String gender = txtGender.getText();
        String birthday = txtBirthday.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();



        try {
            if (existStudent(studentId)) {
                new Alert(Alert.AlertType.ERROR, studentId + " already exists").show();

            } else {
                StudentDTO studentDTO = new StudentDTO(studentId, NIC, name, gender, birthday, age, address);
                studentBO.add(studentDTO);

                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



     /*   String studentId = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String gender = txtGender.getText();
        String birthday = txtBirthday.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();
        if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtName.requestFocus();
            return;
        } else if (!address.matches(".{3,}")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtAddress.requestFocus();
            return;
        }

        if (btnAdd.getText().equalsIgnoreCase("save")) {

            try {
                if (existStudent(studentId)) {
                    new Alert(Alert.AlertType.ERROR, studentId + " already exists").show();
                }
                StudentDTO studentDTO = new StudentDTO(studentId, NIC, name, gender, birthday, age, address);
                studentBO.add(studentDTO);
                tblStudent.getItems().add(new StudentTM(studentId, NIC, name, gender, birthday, age, address));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save the Student " + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } else {

            try {
                if (!existStudent(studentId)) {
                    new Alert(Alert.AlertType.ERROR, "There is no such student associated with the id " + studentId).show();
                }
                StudentDTO studentDTO = new StudentDTO(studentId, NIC, name, gender, birthday, age, address);
                studentBO.update(studentDTO);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the student " + studentId + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            StudentTM selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
            selectedStudent.setNIC(NIC);
            selectedStudent.setName(name);
            selectedStudent.setGender(gender);
            selectedStudent.setBirthday(birthday);
            selectedStudent.setAge(age);
            selectedStudent.setAddress(address);
            tblStudent.refresh();
        }
        btnAddNew.fire();*/

        loadAllStudents();
    }

    private boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return studentBO.ifStudentExist(id);
    }


    public void updateOnAction(ActionEvent actionEvent) {
        String studentId = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String gender = txtGender.getText();
        String birthday = txtBirthday.getText();
        int age = Integer.parseInt(txtAge.getText());
        String address = txtAddress.getText();

        try {
            if(studentBO.update(new StudentDTO(
                    studentId,
                    NIC,
                    name,
                    gender,
                    birthday,
                    age,
                    address
            ))){

                studentBO.findAll();
                txtId.setText(null);
                txtNIC.setText(null);
                txtName.setText(null);
                txtGender.setText(null);
                txtBirthday.setText(null);
                txtAge.setText(null);
                txtAddress.setText(null);

            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        String studentId = tblStudent.getSelectionModel().getSelectedItem().getStudentId();
        try {
            if (!existStudent(studentId)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted" + studentId).show();
            }
            studentBO.delete(studentId);
            tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();
            initUI();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + studentId).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public String addNewOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        return studentBO.generateNewID();

    }

    private String getLastStudentId() {
        List<StudentTM> tempStudentList = new ArrayList<>(tblStudent.getItems());
        Collections.sort(tempStudentList);
        return tempStudentList.get(tempStudentList.size() - 1).getStudentId();
    }
}
