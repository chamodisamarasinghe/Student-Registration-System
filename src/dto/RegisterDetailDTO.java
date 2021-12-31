package dto;

public class RegisterDetailDTO {
   private String programmeId;
   private String registerId;
   private double fee;

    public RegisterDetailDTO() {
    }

    public RegisterDetailDTO(String programmeId, String registerId, double fee) {
        this.setProgrammeId(programmeId);
        this.setRegisterId(registerId);
        this.setFee(fee);
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "RegisterDetailDTO{" +
                "programmeId='" + programmeId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", fee=" + fee +
                '}';
    }
}
