package dao.custom.impl;

import dao.custom.ProgrammeDAO;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import javax.persistence.Query;
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
    public boolean delete(String programmeId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Programme programme = session.get(Programme.class, programmeId);

        session.delete(programme);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Programme find(String programmeId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Programme> list = null;
        String hql = "FROM Programme P WHERE P.programmeId = :programmeId";
        Query query = session.createQuery(hql).setString("programmeId",programmeId);
        list = query.getResultList();
        transaction.commit();

        session.close();
        return list.get(0);
    }

    @Override
    public List<Programme> findAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Programme> list = null;

        Query programmes = session.createQuery("from Programme ");
        list = programmes.getResultList();

        transaction.commit();

        session.close();
        return list;
    }

    public boolean ifProgrammeExist(String programmeId) {
        return false;
    }
}
