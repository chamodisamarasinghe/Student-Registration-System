package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;
import entity.Programme;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProgrammeBO extends SuperBO {
    public boolean add(ProgrammeDTO programmeDTO) throws Exception;

    public List<Programme> findAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(ProgrammeDTO programmeDTO) throws Exception;

    ArrayList<ProgrammeDTO> getAllProgrammes() throws Exception;

    boolean ifProgrammeExist(String programmeId) throws SQLException, ClassNotFoundException;
}
