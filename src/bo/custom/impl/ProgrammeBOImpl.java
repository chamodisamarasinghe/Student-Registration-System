package bo.custom.impl;

import bo.custom.ProgrammeBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.ProgrammeDAOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import entity.Programme;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeBOImpl implements ProgrammeBO {

   ProgrammeDAOImpl programmeDAO = DAOFactory.getInstance().getDAO(DAOType.PROGRAMME);

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
    public List<ProgrammeDTO> findAll() throws Exception {
        return null;
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
    public ArrayList<ProgrammeDTO> getAllProgrammes() {
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
