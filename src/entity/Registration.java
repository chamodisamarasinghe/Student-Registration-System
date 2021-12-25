package entity;

public class Registration {
    private String registerId;
    private String studentId;
    private String registerDate;
    private String time;
    private double payment;

    public Registration() {
    }

    public Registration(String registerId, String studentId, String registerDate, String time, double payment) {
        this.setRegisterId(registerId);
        this.setStudentId(studentId);
        this.setRegisterDate(registerDate);
        this.setTime(time);
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

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registerId='" + registerId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", time='" + time + '\'' +
                ", payment=" + payment +
                '}';
    }
}
