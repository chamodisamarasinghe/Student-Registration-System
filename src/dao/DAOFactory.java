package dao;

import dao.custom.impl.ProgrammeDAOImpl;
import dao.custom.impl.RegisterDetailDAOImpl;
import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return new StudentDAOImpl();
            case PROGRAMME:
                return  new ProgrammeDAOImpl();
            case REGISTRATION:
                return  new RegistrationDAOImpl();
            case REGISTERDETAIL:
                return new RegisterDetailDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType {
        STUDENT, PROGRAMME, REGISTRATION, REGISTERDETAIL
    }
}
