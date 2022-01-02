package dao.custom;

import dao.SuperDAO;
import entity.Registration;

import java.sql.SQLException;

public interface RegistrationDAO extends SuperDAO<Registration, String> {
    boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewRegisterId() throws SQLException, ClassNotFoundException;
}
