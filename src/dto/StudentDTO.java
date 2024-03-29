package dto;

public class StudentDTO {
    private String studentId;
    private String NIC;
    private String name;
    private String gender;
    private String birthday;
    private int age;
    private String address;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String NIC, String name, String gender, String birthday, int age, String address) {
        this.setStudentId(studentId);
        this.setNIC(NIC);
        this.setName(name);
        this.setGender(gender);
        this.setBirthday(birthday);
        this.setAge(age);
        this.setAddress(address);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", NIC='" + NIC + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
