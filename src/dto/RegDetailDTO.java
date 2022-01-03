package dto;

public class RegDetailDTO {
    private String registerId;
    private String studentId;
    private String programmeId;
    private String registerDate;
    private String time;
    private Double payment;

    public RegDetailDTO() {
    }

    public RegDetailDTO(String registerId, String studentId, String programmeId, String registerDate, String time, Double payment) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setProgrammeId(programmeId);
        this.setRegisterDate(registerDate);
        this.setTime(time);
        this.setPayment(payment);
    }

    public RegDetailDTO(String registerId, String studentId, String registerDate, String time) {
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "RegDetailDTO{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", time='" + time + '\'' +
                ", payment=" + payment +
                '}';
    }
}
