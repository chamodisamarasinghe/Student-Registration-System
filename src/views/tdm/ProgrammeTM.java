package views.tdm;

public class ProgrammeTM {
    private String programmeId;
    private String programmeName;
    private String duration;
    private double fee;

    public ProgrammeTM() {
    }

    public ProgrammeTM(String programmeId, String programmeName, String duration, double fee) {
        this.setProgrammeId(programmeId);
        this.setProgrammeName(programmeName);
        this.setDuration(duration);
        this.setFee(fee);
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

    @Override
    public String toString() {
        return "ProgrammeTM{" +
                "programmeId='" + programmeId + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
