package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    ArrayList<StudentDTO> getAllStudents()throws SQLException, ClassNotFoundException;

    StudentDTO searchStudent(String studentId)throws SQLException, ClassNotFoundException;

    boolean ifStudentExist(String studentId)throws SQLException, ClassNotFoundException;

    boolean confirmRegister(RegistrationDTO dto) throws SQLException, ClassNotFoundException;

    String generateNewOrderId()throws SQLException, ClassNotFoundException;

    ArrayList<ProgrammeDTO> getAllProgrammes()throws SQLException, ClassNotFoundException;

    ProgrammeDTO searchProgramme(String programmeId)throws SQLException, ClassNotFoundException;

    boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException;


}
