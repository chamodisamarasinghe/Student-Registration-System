package controller;

import bo.BoFactory;
import bo.custom.RegistrationBO;
import bo.custom.impl.RegistrationBOImpl;
import com.jfoenix.controls.JFXButton;
import dto.*;
import entity.RegisterDetail;
import entity.Registration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.tdm.RegistrationTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public JFXButton btnAdd;
    private String registerId;
    int cartSelectedRowForRemove = -1;


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
                StudentDTO studentDTO = registrationBO.searchStudent(newValue + "");
                txtNIC.setText(studentDTO.getNIC());
                txtName.setText(studentDTO.getName());
                txtGender.setText(studentDTO.getGender());
                txtBirthday.setText(studentDTO.getBirthday());
                txtAge.setText(String.valueOf(studentDTO.getAge()));
                txtAddress.setText(studentDTO.getAddress());

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the student " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        tblRegistration.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });

        try {
            loadProgrammeIds();
        } catch (Exception e) {
            e.printStackTrace();
        }


        cmbProgrammeId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ProgrammeDTO programmeDTO = registrationBO.searchProgramme(newValue + "");
                txtProgramme.setText(programmeDTO.getProgrammeName());
                txtDuration.setText(programmeDTO.getDuration());
                txtFee.setText(String.valueOf(programmeDTO.getFee()));

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the programme " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        registerId = String.valueOf(generateNewRegisterId());
        lblRegId.setText(registerId);
        loadDateAndTime();


            }

    private void loadDateAndTime() {
        Date date=new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void loadProgrammeIds() {
        ArrayList<ProgrammeDTO> all = null;
        try {
            all = registrationBO.getAllProgrammes();
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
        return registrationBO.ifStudentExist(studentId);
    }

    private boolean existProgramme(String programmeId) throws SQLException, ClassNotFoundException {
        return registrationBO.ifProgrammeExist(programmeId);
    }


    private void loadAllStudentIds() throws Exception {
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


    ObservableList<RegistrationTM> obList = FXCollections.observableArrayList();
    public void addOnAction(ActionEvent actionEvent) {
            String registerId = lblRegId.getText();
            String studentId = String.valueOf(cmbStudentId.getValue());
            String programId = String.valueOf(cmbProgrammeId.getValue());
            String studentName = txtName.getText();
            String address = txtAddress.getText();
            String programme = txtProgramme.getText();
            String duration = txtDuration.getText();
            double payment = Double.parseDouble(txtFee.getText());

            RegistrationTM tm = new RegistrationTM(
                    registerId,
                    studentId,
                    programId,
                    studentName,
                    address,
                    programme,
                    duration,
                    payment
            );

            int rowNumber = isExists(tm);

            if ( rowNumber==-1) {
                obList.add(tm);
            } else {
                RegistrationTM temp = obList.get(rowNumber);
                RegistrationTM newTm = new RegistrationTM(
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
                obList.add(newTm);
            }

            tblRegistration.setItems(obList);

            calculate();
        }

        private int isExists(RegistrationTM tm) {

            for (int i = 0; i < obList.size(); i++) {
                if (tm.getProgrammeId().equals(obList.get(i).getProgrammeId())){
                    return i;
                }
            }
            return -1;
        }
        void calculate() {
            double ttl = 0;
            for (RegistrationTM tm : obList
            ) {
                ttl += tm.getPayment();
            }
            lblTotal.setText(ttl+"");
        }





    private boolean isExists(String registerId) throws SQLException, ClassNotFoundException {
        return registrationBO.ifRegisterExist(registerId);
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        if (cartSelectedRowForRemove==-1){
            new Alert(Alert.AlertType.WARNING, "Please Select a row").show();
        }else{
            obList.remove(cartSelectedRowForRemove);
            tblRegistration.refresh();
        }
    }

    public void confirmOnAction(ActionEvent actionEvent) throws Exception {
        RegisterDTO registerDTO= new RegisterDTO(
                lblRegId.getText(),
                String.valueOf(cmbStudentId.getValue()),
                String.valueOf(cmbProgrammeId.getValue()),
                lblDate.getText(),
                lblTime.getText(),
                tblRegistration.getItems().stream().map(tm ->
                        new RegisterDetailDTO(tm.getProgrammeId(),tm.getStudentId())).collect(Collectors.toList())


        );

        if (registrationBO.confirmRegister(registerDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Registered Successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again ").show();
        }

        registerId = String.valueOf(generateNewRegisterId());
        lblRegId.setText(String.valueOf(generateNewRegisterId()));
        tblRegistration.getItems().clear();
        clearText();


    }

    private void clearText() {

    }


    private Object generateNewRegisterId() {
        try {
            return registrationBO.generateNewOrderId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new register id").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
