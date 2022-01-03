package dao.custom.impl;

import dao.custom.RegisterDetailDAO;
import entity.Programme;
import entity.RegisterDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.List;

public class RegisterDetailDAOImpl implements RegisterDetailDAO {
    @Override
    public boolean add(RegisterDetail entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(RegisterDetail entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public RegisterDetail find(String s) throws Exception {
        return null;
    }

    @Override
    public List<RegisterDetail> findAll() throws Exception {
        return null;
    }
}
