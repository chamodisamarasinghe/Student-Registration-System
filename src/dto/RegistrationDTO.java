package dto;

public class RegistrationDTO {
    private String registerId;
    private String studentId;
    private String registerDate;
    private String time;


    public RegistrationDTO() {
    }

    public RegistrationDTO(String registerId, String studentId, String registerDate, String time) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setRegisterDate(registerDate);
        this.setTime(time);

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



    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", time='" + time + '\'' +
                '}';
    }



}
