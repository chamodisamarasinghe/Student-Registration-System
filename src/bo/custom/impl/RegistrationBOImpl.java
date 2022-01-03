package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.ProgrammeDAO;
import dao.custom.RegisterDetailDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    private final ProgrammeDAO programmeDAO = (ProgrammeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);
    private final RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.REGISTRATION);
    private final RegisterDetailDAO registerDetailDAO = (RegisterDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.REGISTERDETAIL);

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
       ArrayList<StudentDTO> allStudents = new ArrayList<>();
        List<Student> all = studentDAO.findAll();
        for (Student student: all){
            allStudents.add(new StudentDTO(student.getStudentId(),student.getNIC(),student.getName(),student.getGender(),
                    student.getBirthday(), student.getAge(), student.getAddress()));
        }
        return allStudents;
    }

    @Override
    public StudentDTO searchStudent(String studentId) throws Exception {
        Student student = studentDAO.find(studentId);
        return new StudentDTO(student.getStudentId(),student.getNIC(),student.getName(),student.getGender(),
                student.getBirthday(), student.getAge(), student.getAddress());

    }

    @Override
    public boolean ifStudentExist(String studentId) throws SQLException, ClassNotFoundException {
        return registrationDAO.ifRegisterExist(studentId);
    }

    @Override
    public boolean confirmRegister(RegisterDTO dto) throws Exception {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            boolean registerAvailable = registrationDAO.ifRegisterExist(dto.getRegisterId());
            if (registerAvailable) {
                return false;
            }

            Student student = studentDAO.find(dto.getStudentId());
            Registration registration = new Registration(dto.getRegisterId(), dto.getRegisterDate(),dto.getTime(),student);
            boolean registerAdded = registrationDAO.add(registration);
            if (!registerAdded) {

                transaction.commit();

                session.close();
                return false;
            }

            Student student1 = studentDAO.find(dto.getStudentId());
            Programme programme = programmeDAO.find(dto.getProgrammeId());

            for (RegisterDetailDTO detailDTO : dto.getRegisterDetail()) {
                RegisterDetail registerDetail = new RegisterDetail(Long.parseLong("0"), programme, student1);
                boolean registerDetailAdd = registerDetailDAO.add(registerDetail);
                if (!registerDetailAdd) {
                    transaction.commit();
                    session.close();
                    return false;
                }
            }


            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return registrationDAO.generateNewRegisterId();
    }

    @Override
    public ArrayList<ProgrammeDTO> getAllProgrammes() throws Exception {
        ArrayList<ProgrammeDTO> allProgrammes = new ArrayList<>();
        List<Programme> all = programmeDAO.findAll();
        for (Programme programme: all){
            allProgrammes.add(new ProgrammeDTO(programme.getProgrammeId(),programme.getProgrammeName(),
                    programme.getDuration(),programme.getFee()
                    ));
        }
        return allProgrammes;
    }

    @Override
    public ProgrammeDTO searchProgramme(String programmeId) throws Exception {
        Programme programme = programmeDAO.find(programmeId);
        return new ProgrammeDTO(programme.getProgrammeId(),programme.getProgrammeName(),programme.getDuration(),programme.getFee());
    }

    @Override
    public boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException {
        return registrationDAO.ifRegisterExist(programmeId);
    }

    @Override
    public boolean ifRegisterExist(String registerId) throws SQLException, ClassNotFoundException {
        return registrationDAO.ifRegisterExist(registerId);
    }

    @Override
    public List<RegistrationDTO> findAll() throws Exception {
        List<Registration> all = registrationDAO.findAll();
        ArrayList<RegistrationDTO> dtoList = new ArrayList<>();
        for (Registration registration : all) {
            dtoList.add(new RegistrationDTO(
                    registration.getRegisterId(),
                    registration.getStudent().getStudentId(),
                    registration.getRegisterDate(),
                    registration.getTime()


            ));
        }
        return dtoList;
    }


}
