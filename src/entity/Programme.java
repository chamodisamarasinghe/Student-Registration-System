package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Programme implements SuperEntity {
    @Id
    private String programmeId;
    private String programmeName;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "programmeId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<RegisterDetail> pid;

    public Programme() {
    }





    public Programme(String programmeId, String programmeName, String duration, double fee) {
        this.setProgrammeId(programmeId);
        this.setProgrammeName(programmeName);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public Programme(String programmeId, String programmeName, String duration, double fee, List<RegisterDetail> pid) {
        this.setProgrammeId(programmeId);
        this.setProgrammeName(programmeName);
        this.setDuration(duration);
        this.setFee(fee);
        this.setPid(pid);
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

    public List<RegisterDetail> getPid() {
        return pid;
    }

    public void setPid(List<RegisterDetail> pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "programmeId='" + programmeId + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", pid=" + pid +
                '}';
    }
}
