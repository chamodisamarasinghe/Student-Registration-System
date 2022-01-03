package dao.custom.impl;

import dao.custom.RegistrationDAO;
import entity.Programme;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean add(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String registerId) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Registration registration = session.get(Registration.class,registerId);

        session.delete(registration);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Registration find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Registration> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean ifRegisterExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewRegisterId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Registration r ORDER BY r.registerId desc";
        Query query = session.createQuery(hql);
        List resultList = ((org.hibernate.query.Query) query).getResultList();
        transaction.commit();
        session.close();
        if(resultList.size()>0) {
            int tempId = Integer.parseInt(((Registration) resultList.get(0)).getRegisterId().split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "R-00" + tempId;
            } else if (tempId <= 99) {
                return "R-0" + tempId;
            } else {
                return "R-" + tempId;
            }
        }else {
            return "R-001";
            }
        }
    }

