package dto;

public class RegisterDetailDTO {
    private Long registerId;
    private String studentId;

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
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

    private String programmeId;

    public RegisterDetailDTO() {
    }

    public RegisterDetailDTO(Long registerId, String studentId, String programmeId) {
        this.registerId = registerId;
        this.studentId = studentId;
        this.programmeId = programmeId;
    }

    public RegisterDetailDTO( String studentId, String programmeId) {
        this.studentId = studentId;
        this.programmeId = programmeId;
    }

    @Override
    public String toString() {
        return "RegisterDetailDTO{" +
                "registerId=" + registerId +
                ", studentId='" + studentId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                '}';
    }
}
