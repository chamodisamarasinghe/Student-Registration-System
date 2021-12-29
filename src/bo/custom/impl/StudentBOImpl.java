package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getStudentId(),
                studentDTO.getNIC(),
                studentDTO.getName(),
                studentDTO.getGender(),
                studentDTO.getBirthday(),
                studentDTO.getAge(),
                studentDTO.getAddress()
        ));
    }

    @Override
    public List<StudentDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getStudentId(),
                studentDTO.getNIC(),
                studentDTO.getName(),
                studentDTO.getGender(),
                studentDTO.getBirthday(),
                studentDTO.getAge(),
                studentDTO.getAddress()
        ));
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        for (Student student : all) {
            dtoList.add(new StudentDTO(
                    student.getStudentId(),
                    student.getNIC(),
                    student.getName(),
                    student.getGender(),
                    student.getBirthday(),
                    student.getAge(),
                    student.getAddress()

            ));
        }
        return dtoList;

    }

    @Override
    public boolean ifStudentExist(String studentId) throws SQLException, ClassNotFoundException {
        return studentDAO.ifStudentExist(studentId);
    }

    @Override
    public String generateNewID() {
        return null;
    }


}
