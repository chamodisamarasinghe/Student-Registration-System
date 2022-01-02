package controller;

import bo.BoFactory;
import bo.custom.impl.RegistrationBOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.RegistrationTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterFormController {
    private final RegistrationBOImpl registrationBOImpl = (RegistrationBOImpl)  BoFactory.getBoFactory().getBO(BoFactory.BoTypes.REGISTRATION);

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
    public TableView<RegistrationTM> tblRegistration;
    public Label lblTotal;
    public Label lblRegId;
    public TableColumn colRegisterId;
    public TableColumn colStudentId;
    public TableColumn colProgrammeId;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colDuration;
    public TableColumn colProgramme;
    public TableColumn colPayment;
    private Object RegistrationTM;


    public void initialize(){
        colRegisterId.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colProgrammeId.setCellValueFactory(new PropertyValueFactory<>("programmeId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colProgramme.setCellValueFactory(new PropertyValueFactory<>("programme"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));



        try {
            loadAllStudentIds();
        } catch (Exception e) {
            e.printStackTrace();
        }

        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                StudentDTO studentDTO = registrationBOImpl.searchStudent(newValue + "");
                txtNIC.setText(studentDTO.getNIC());
                txtName.setText(studentDTO.getName());
                txtGender.setText(studentDTO.getGender());
                txtBirthday.setText(studentDTO.getBirthday());
                txtAge.setText(String.valueOf(studentDTO.getAge()));
                txtAddress.setText(studentDTO.getAddress());

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the customer " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });



        try {
            loadProgrammeIds();
        } catch (Exception e) {
            e.printStackTrace();
        }


        cmbProgrammeId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ProgrammeDTO programmeDTO = registrationBOImpl.searchProgramme(newValue + "");
                txtProgramme.setText(programmeDTO.getProgrammeName());
                txtDuration.setText(programmeDTO.getDuration());
                txtFee.setText(String.valueOf(programmeDTO.getFee()));

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the customer " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

            }

    private void loadProgrammeIds() throws Exception{
        ArrayList<ProgrammeDTO> all = null;
        try {
            all = registrationBOImpl.getAllProgrammes();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ProgrammeDTO dto : all) {
            cmbProgrammeId.getItems().add(dto.getProgrammeId());
        }
    }


    private void enableOrDisableConfirmButton() {
    }

    private boolean existStudent(String studentId) throws SQLException, ClassNotFoundException {
        return registrationBOImpl.ifStudentExist(studentId);
    }

    private boolean existProgramme(String programmeId) throws SQLException, ClassNotFoundException {
        return registrationBOImpl.ifProgrammeExist(programmeId);
    }


    private void loadAllStudentIds() throws Exception {
        ArrayList<StudentDTO> all = null;
        try {
            all = registrationBOImpl.getAllStudents();
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
      /*  try {
            String registerId = lblRegId.getId();
            String studentID = String.valueOf(cmbStudentId.getValue());
            String programmeId = String.valueOf(cmbProgrammeId.getValue());
            String studentName = txtName.getText();
            String address = txtAddress.getText();
            String programme = txtProgramme.getText();
            String duration = txtDuration.getText();
            double payment = Double.parseDouble(lblTotal.getText());


            RegistrationTM tm = new RegistrationTM(
                    registerId,
                    studentID,
                    programmeId,
                    studentName,
                    address,
                    programme,
                    duration,
                    payment
            );
            int rowNumber = isExists(tm);

            if (rowNumber == -1) {
                obList.add(tm);
            } else {
                RegistrationTM temp = obList.get(rowNumber);
                RegistrationTM = new RegistrationTM(
                        temp.getRegisterId(),
                        temp.getStudentId(),
                        temp.getProgrammeId(),
                        temp.getStudentName(),
                        temp.getAddress(),
                        temp.getProgramme(),
                        temp.getDuration(),
                        temp.getPayment()
                );

                obList.remove(rowNumber);
               // obList.add(newTm);
            }
            tblRegistration.setItems(obList);
            calculatePayment();


        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            e.printStackTrace();
        }*/
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

    private void calculatePayment() {
    }

    private boolean isExists(String registerId) throws SQLException, ClassNotFoundException {
        return registrationBOImpl.ifRegisterExist(registerId);
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }

    public void confirmOnAction(ActionEvent actionEvent) {
    }
}
