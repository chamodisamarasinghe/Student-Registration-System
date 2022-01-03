package entity;

import javax.persistence.*;

@Entity
public class RegisterDetail implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registerId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "programmeId")
    private Programme programmeId;

    @ManyToOne
    @JoinColumn(name = "sid" )
    private Student sid;

    public RegisterDetail() {
    }

    public RegisterDetail(Long registerId, Programme programmeId, Student sid) {
        this.registerId = registerId;
        this.programmeId = programmeId;
        this.sid = sid;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Programme getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(Programme programmeId) {
        this.programmeId = programmeId;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "RegisterDetail{" +
                "registerId=" + registerId +
                ", programmeId=" + programmeId +
                ", sid=" + sid +
                '}';
    }
}
