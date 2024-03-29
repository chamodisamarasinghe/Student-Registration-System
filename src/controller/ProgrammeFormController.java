package controller;

import bo.BoFactory;
import bo.custom.ProgrammeBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.ProgrammeTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ProgrammeFormController {
    private final ProgrammeBO programmeBO = BoFactory.getBoFactory().getBO(BoFactory.BoTypes.PROGRAMME);
    public AnchorPane programmeFormContext;
    public TextField txtId;
    public TableView<ProgrammeTM> tblProgramme;
    public TableColumn colId;
    public TableColumn colProgramme;
    public TableColumn colDuration;
    public TableColumn colFee;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public TextField txtProgramme;
    public TextField txtDuration;
    public TextField txtFee;

    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap();
    Pattern programmeIDPattern = Pattern.compile("^(CT)[0-9]{3,4}$");
    Pattern programmePattern = Pattern.compile("^[A-z ]{2,}$");
    Pattern durationPattern = Pattern.compile("^[0-9]{1,2}$");


    public void initialize(){
        storeValidation();

        colId.setStyle("-fx-border-color: black;-fx-table-cell-border-color:black;");
        colProgramme.setStyle("-fx-border-color: black;-fx-table-cell-border-color:black;");
        colDuration.setStyle("-fx-border-color: black;-fx-table-cell-border-color:black;");
        colFee.setStyle("-fx-border-color: black;-fx-table-cell-border-color:black;");


        tblProgramme.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("programmeId"));
        tblProgramme.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("programmeName"));
        tblProgramme.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblProgramme.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        initUI();
        tblProgramme.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtId.setText(newValue.getProgrammeId());
                txtProgramme.setText(newValue.getProgrammeName());
                txtDuration.setText(newValue.getDuration());
                txtFee.setText(String.valueOf(newValue.getFee()));

                txtId.setDisable(false);
                txtProgramme.setDisable(false);
                txtDuration.setDisable(false);
                txtFee.setDisable(false);

            }
        });

        txtFee.setOnAction(event -> btnSave.fire());
        try {
            loadProgrammes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeValidation() {
        map.put(txtId, programmeIDPattern);
        map.put(txtProgramme, programmePattern);
        map.put(txtDuration, durationPattern);

    }

    private void loadProgrammes() throws Exception {
        tblProgramme.getItems().clear();
        ArrayList<ProgrammeDTO> allProgrammes = programmeBO.getAllProgrammes();
        for (ProgrammeDTO programme : allProgrammes) {
            tblProgramme.getItems().add(new ProgrammeTM(programme.getProgrammeId(), programme.getProgrammeName(),
                    programme.getDuration(), programme.getFee()));
        }

    }

    private void initUI() {
        txtId.clear();
        txtProgramme.clear();
        txtDuration.clear();
        txtFee.clear();
       /* txtId.setDisable(false);
        txtProgramme.setDisable(true);
        txtDuration.setDisable(true);
        txtFee.setDisable(true);
        txtId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);*/
    }

    public void openHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) programmeFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addOnAction(ActionEvent actionEvent) throws Exception {
        String programmeId = txtId.getText();
        String programmeName = txtProgramme.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        try {
            if (existProgramme(programmeId)) {
                new Alert(Alert.AlertType.ERROR, programmeId + " already exists").show();

            } else {
                ProgrammeDTO programmeDTO = new ProgrammeDTO(programmeId, programmeName, duration, fee);
                programmeBO.add(programmeDTO);

                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        loadProgrammes();
    }

        public void updateOnAction (ActionEvent actionEvent){
            String programmeId = txtId.getText();
            String programmeName = txtProgramme.getText();
            String duration = txtDuration.getText();
            double fee = Double.parseDouble(txtFee.getText());

            try {
                if(programmeBO.update(new ProgrammeDTO(
                        programmeId,
                        programmeName,
                        duration,
                        fee
                ))){

                    programmeBO.findAll();
                    txtId.setText(null);
                    txtProgramme.setText(null);
                    txtDuration.setText(null);
                    txtFee.setText(null);

                }else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated").show();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }

            try {
                loadProgrammes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void deleteOnAction (ActionEvent actionEvent){
            String programmeId = tblProgramme.getSelectionModel().getSelectedItem().getProgrammeId();
            try {
                if (!existProgramme(programmeId)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted" + programmeId).show();
                }
                programmeBO.delete(programmeId);
                tblProgramme.getItems().remove(tblProgramme.getSelectionModel().getSelectedItem());
                tblProgramme.getSelectionModel().clearSelection();
                initUI();

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete the student " + programmeId).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private boolean existProgramme (String programmeId) throws SQLException, ClassNotFoundException {
            return programmeBO.ifProgrammeExist(programmeId);
        }

    public void textFieldsKeyReleased(KeyEvent keyEvent) {
        Object response = ValidationUtil.validate(map, btnSave);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof TextField) {
                TextField errorText = (TextField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {
                new Alert(Alert.AlertType.INFORMATION, "Added").showAndWait();
            }
        }
    }

    public void moveToName(ActionEvent actionEvent) {
        txtProgramme.requestFocus();
    }

    public void moveToDuration(ActionEvent actionEvent) {
        txtDuration.requestFocus();
    }

    public void moveToFee(ActionEvent actionEvent) {
        txtFee.requestFocus();
    }
}
