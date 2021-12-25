package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "programme")
public class Programme {
    @Id
    private String programmeId;
    private String programmeName;
    private String duration;
    private double fee;

    @ManyToMany(mappedBy = "programmeList")
    private List<Student> studentList = new ArrayList<>();

    public Programme() {
    }

    public Programme(String programmeId, String programmeName, String duration, double fee, List<Student> studentList) {
        this.setProgrammeId(programmeId);
        this.setProgrammeName(programmeName);
        this.setDuration(duration);
        this.setFee(fee);
        this.setStudentList(studentList);
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "programmeId='" + programmeId + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", studentList=" + studentList +
                '}';
    }
}
