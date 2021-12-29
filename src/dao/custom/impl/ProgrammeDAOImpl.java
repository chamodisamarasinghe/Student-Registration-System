package dao.custom.impl;

import dao.custom.ProgrammeDAO;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.List;

public class ProgrammeDAOImpl implements ProgrammeDAO {
    @Override
    public boolean add(Programme entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Programme entity) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Programme programme = session.get(Programme.class, s);

        session.delete(s);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Programme find(String s) {
        return null;
    }

    @Override
    public List<Programme> findAll() {
        return null;
    }

    public boolean ifProgrammeExist(String programmeId) {
        return false;
    }
}
