package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;

import dao.custom.ProgrammeDAO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

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
    public List<Student> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = null;

        Query students = session.createQuery("from Student ");
        list = ((org.hibernate.query.Query) students).list();

        transaction.commit();

        session.close();
        return list;
    }


    @Override
    public boolean delete(String studentId) throws Exception {
        return studentDAO.delete(studentId);
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
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
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

    @Override
    public StudentDTO find(String studentId) throws SQLException, ClassNotFoundException {
        return null;
    }


}
