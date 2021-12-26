package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;

import java.util.List;

public interface ProgrammeBO extends SuperBO {
    public boolean add(ProgrammeDTO programmeDTO) throws Exception;

    public List<ProgrammeDTO> findAll() throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(ProgrammeDTO programmeDTO) throws Exception;
}
