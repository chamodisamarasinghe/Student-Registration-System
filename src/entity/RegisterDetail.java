package entity;

public class RegisterDetail {
    private String registerId;
    private String studentId;
    private String programmeId;

    public RegisterDetail() {
    }

    public RegisterDetail(String registerId, String studentId, String programmeId) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setProgrammeId(programmeId);
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

    @Override
    public String toString() {
        return "RegisterDetail{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                '}';
    }
}
