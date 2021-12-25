package entity;

public class RegisterDetail {
    private String programmeId;
    private String registerId;
    private int qty;
    private double fee;

    public RegisterDetail() {
    }

    public RegisterDetail(String programmeId, String registerId, int qty, double fee) {
        this.setProgrammeId(programmeId);
        this.setRegisterId(registerId);
        this.setQty(qty);
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "RegisterDetail{" +
                "programmeId='" + programmeId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", qty=" + qty +
                ", fee=" + fee +
                '}';
    }
}
