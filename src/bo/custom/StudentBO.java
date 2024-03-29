package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;

    public List<Student> findAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;

    ArrayList<StudentDTO> getAllStudents() throws Exception;

    boolean ifStudentExist(String studentId) throws SQLException, ClassNotFoundException;

    String generateNewID();

    StudentDTO find(String studentId) throws SQLException, ClassNotFoundException;

    StudentDTO getStudents(String valueOf) throws Exception;
}
