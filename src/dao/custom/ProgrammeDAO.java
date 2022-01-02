package dao.custom;

import dao.SuperDAO;
import entity.Programme;

import java.sql.SQLException;

public interface ProgrammeDAO extends SuperDAO<Programme, String> {
    boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException;
}
