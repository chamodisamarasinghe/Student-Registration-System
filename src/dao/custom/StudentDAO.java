package dao.custom;

import dao.SuperDAO;
import entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends SuperDAO<Student, String> {
    boolean ifStudentExist(String id) throws SQLException, ClassNotFoundException;
}
