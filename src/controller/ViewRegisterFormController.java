package controller;

import bo.BoFactory;
import bo.custom.ProgrammeBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import dto.ProgrammeDTO;
import dto.RegDetailDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.tdm.RegisterDetailTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ViewRegisterFormController {
    private final RegistrationBO registrationBO = (RegistrationBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.REGISTRATION);
    private final StudentBO studentBO = (StudentBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.STUDENT);
    private final ProgrammeBO programmeBO = (ProgrammeBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.PROGRAMME);


    public AnchorPane regDetailContext;
    public TableView<RegisterDetailTM> tblRegisterDetail;
    public TableColumn colRegId;
    public TableColumn colStudentId;
    public TableColumn colProgrammeId;
    public TableColumn colRegDate;
    public TableColumn colPayment;
    public TableColumn colTime;

    public void initialize(){

        colRegId.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colProgrammeId.setCellValueFactory(new PropertyValueFactory<>("programmeId"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));

        loadDetails();
    }

    private void loadDetails() {
      /*  tblRegisterDetail.getItems().clear();
        try {
            List<RegDetailDTO> allRegistrations = registrationBO.findAll();
            for (RegDetailDTO regDetailDTO : allRegistrations) {
                tblRegisterDetail.getItems().add(new RegisterDetailTM(regDetailDTO.getRegisterId(),regDetailDTO.getStudentId(),regDetailDTO.getProgrammeId(),
                        regDetailDTO.getRegisterDate(),
                        regDetailDTO.getTime(), regDetailDTO.getPayment()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblRegisterDetail.getItems();*/
    }

    public void openHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../views/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) regDetailContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
