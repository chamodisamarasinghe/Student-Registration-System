package bo.custom;

import bo.SuperBO;
import dto.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegistrationBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudents() throws Exception;

    StudentDTO searchStudent(String studentId) throws Exception;

    boolean ifStudentExist(String studentId)throws SQLException, ClassNotFoundException;

    boolean confirmRegister(RegisterDTO dto) throws Exception;

    String generateNewOrderId()throws SQLException, ClassNotFoundException;

    ArrayList<ProgrammeDTO> getAllProgrammes() throws Exception;

    ProgrammeDTO searchProgramme(String programmeId) throws Exception;

    boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException;


    boolean ifRegisterExist(String registerId) throws SQLException, ClassNotFoundException;

    List<RegisterDTO> findAll() throws Exception;

    RegisterDTO getRegister(String registerId) throws Exception;
}
