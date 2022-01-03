package views.tdm;

public class RegistrationTM {
    private String registerId;
    private String studentId;
    private String programmeId;
    private String studentName;
    private String address;
    private String programme;
    private String duration;
    private double payment;


    public RegistrationTM() {
    }

    public RegistrationTM(String registerId, String studentId, String programmeId, String studentName,
                          String address, String programme, String duration, double payment) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setProgrammeId(programmeId);
        this.setStudentName(studentName);
        this.setAddress(address);
        this.setProgramme(programme);
        this.setDuration(duration);
        this.setPayment(payment);

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }



    @Override
    public String toString() {
        return "RegistrationTM{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", programmeId='" + programmeId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", programme='" + programme + '\'' +
                ", duration='" + duration + '\'' +
                ", payment=" + payment +
                '}';
    }


}
