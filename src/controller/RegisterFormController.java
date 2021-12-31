package controller;

import bo.BoFactory;
import bo.custom.RegistrationBO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterFormController {
    private final RegistrationBO registrationBO = (RegistrationBO)  BoFactory.getBoFactory().getBO(BoFactory.BoTypes.REGISTRATION);

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
    public Label lblRegId;


    public void initialize(){
        loadAllStudentIds();

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            enableOrDisableConfirmButton();

            if (newValue != null) {
                try {
                    if (!existStudent(newValue + "")) {

                        new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + newValue + "").show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                StudentDTO studentDTO = null;
                try {
                    studentDTO = registrationBO.searchStudent(newValue + "");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                txtNIC.setText(studentDTO.getNIC());
                txtName.setText(studentDTO.getName());
                txtGender.setText(studentDTO.getGender());
                txtBirthday.setText(studentDTO.getAddress());
                txtAge.setText(String.valueOf(studentDTO.getAge()));
                txtAddress.setText(studentDTO.getAddress());


            } else {
                txtName.clear();
            }
        });
            }


    private void enableOrDisableConfirmButton() {
    }

    private boolean existStudent(String studentId) throws SQLException, ClassNotFoundException {
        return registrationBO.ifStudentExist(studentId);
    }


    private void loadAllStudentIds() {
        ArrayList<StudentDTO> all = null;
        try {
            all = registrationBO.getAllStudents();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (StudentDTO dto : all) {
            cmbStudentId.getItems().add(dto.getStudentId());
        }
    }

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) registerFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addOnAction(ActionEvent actionEvent) {

       /* String itemCode = cmbCode.getSelectionModel().getSelectedItem();
        String description = txtDescription.getText();
        String packSize = txtPackSize.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrize.getText());
        // int qty = Integer.parseInt(txtQty.getText());
        double total = qty * unitPrice;

        boolean exists = tblOrderDetails.getItems().stream().anyMatch(detail -> detail.getCode().equals(itemCode));

        if (exists) {
            OrderDetailTM orderDetailTM = tblOrderDetails.getItems().stream().filter(detail -> detail.getCode().equals(itemCode)).findFirst().get();

            if (btnSave.getText().equalsIgnoreCase("Update")) {
                orderDetailTM.setQty(qty);
                orderDetailTM.setTotal(total);
                tblOrderDetails.getSelectionModel().clearSelection();
            } else {
                orderDetailTM.setQty(orderDetailTM.getQty() + qty);
                total = qty * unitPrice;
                orderDetailTM.setTotal(total);
            }
            tblOrderDetails.refresh();
        } else {
            tblOrderDetails.getItems().add(new OrderDetailTM(itemCode, description, packSize, qty, unitPrice, total));
        }
        cmbCode.getSelectionModel().clearSelection();
        cmbCode.requestFocus();
        calculateTotal();
        enableOrDisablePlaceOrderButton();*/
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }

    public void confirmOnAction(ActionEvent actionEvent) {
    }
}
