package dto;

import java.util.List;

public class RegisterDTO {
   private String registerId;
   private String studentId;
   private String programmeId;
   private String registerDate;
   private String time;
   private List<RegisterDetailDTO> registerDetail;

    public RegisterDTO() {
    }

    public RegisterDTO(String registerId, String studentId, String programmeId, String registerDate, String time, List<RegisterDetailDTO> registerDetail) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setProgrammeId(programmeId);
        this.setRegisterDate(registerDate);
        this.setTime(time);
        this.setRegisterDetail(registerDetail);
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<RegisterDetailDTO> getRegisterDetail() {
        return registerDetail;
    }

    public void setRegisterDetail(List<RegisterDetailDTO> registerDetail) {
        this.registerDetail = registerDetail;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", time='" + time + '\'' +
                ", registerDetail=" + registerDetail +
                '}';
    }
}
