package bo.custom.impl;

import bo.custom.RegistrationBO;
import dto.ProgrammeDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {
    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public StudentDTO searchStudent(String studentId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifStudentExist(String studentId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean confirmRegister(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ProgrammeDTO> getAllProgrammes() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ProgrammeDTO searchProgramme(String programmeId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException {
        return false;
    }
}
