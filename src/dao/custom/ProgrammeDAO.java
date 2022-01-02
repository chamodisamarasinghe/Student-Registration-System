package dao.custom;

import dao.SuperDAO;
import entity.Programme;

public interface ProgrammeDAO extends SuperDAO<Programme, String> {
    boolean ifProgrammeExist(String programmeId);
}
