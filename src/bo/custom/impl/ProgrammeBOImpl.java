package bo.custom.impl;

import bo.custom.ProgrammeBO;
import dao.DAOFactory;

import dao.custom.ProgrammeDAO;
import dto.ProgrammeDTO;
import entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProgrammeBOImpl implements ProgrammeBO {

   ProgrammeDAO programmeDAO = (ProgrammeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);

    @Override
    public boolean add(ProgrammeDTO programmeDTO) throws Exception {
        return programmeDAO.add(new Programme(
                programmeDTO.getProgrammeId(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));

    }

    @Override
    public List<Programme> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Programme> list = null;

        Query programmes = session.createQuery("from Programme ");
        list = ((org.hibernate.query.Query) programmes).list();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return programmeDAO.delete(id);
    }

    @Override
    public boolean update(ProgrammeDTO programmeDTO) throws Exception {
        return programmeDAO.update(new Programme(
                programmeDTO.getProgrammeId(),
                programmeDTO.getProgrammeName(),
                programmeDTO.getDuration(),
                programmeDTO.getFee()
        ));
    }

    @Override
    public ArrayList<ProgrammeDTO> getAllProgrammes() throws Exception {
        List<Programme> all = programmeDAO.findAll();
        ArrayList<ProgrammeDTO> dtoList = new ArrayList<>();

        for (Programme programme : all) {
            dtoList.add(new ProgrammeDTO(
                    programme.getProgrammeId(),
                    programme.getProgrammeName(),
                    programme.getDuration(),
                    programme.getFee()
            ));
        }
        return dtoList;
    }

    @Override
    public boolean ifProgrammeExist(String programmeId) {
        return programmeDAO.ifProgrammeExist(programmeId);
    }
}
