package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student implements SuperEntity {
    @Id
    private String studentId;
    private String NIC;
    private String name;
    private String gender;
    private String birthday;
    private int age;
    private String address;

   @OneToMany(mappedBy = "sid")
   private List<RegisterDetail> sid;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Registration> registration;

    public Student(String studentId, String NIC, String name, String gender, String birthday, int age, String address) {
        this.setStudentId(studentId);
        this.setNIC(NIC);
        this.setName(name);
        this.setGender(gender);
        this.setBirthday(birthday);
        this.setAge(age);
        this.setAddress(address);

    }


    public Student() {
    }

    public Student(String studentId, String NIC, String name, String gender, String birthday, int age, String address, List<RegisterDetail> sid, List<Registration> registration) {
        this.setStudentId(studentId);
        this.setNIC(NIC);
        this.setName(name);
        this.setGender(gender);
        this.setBirthday(birthday);
        this.setAge(age);
        this.setAddress(address);
        this.setSid(sid);
        this.setRegistration(registration);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + getStudentId() + '\'' +
                ", NIC='" + getNIC() + '\'' +
                ", name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                ", sid=" + getSid() +
                ", registration=" + getRegistration() +
                '}';
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

    public List<RegisterDetail> getSid() {
        return sid;
    }

    public void setSid(List<RegisterDetail> sid) {
        this.sid = sid;
    }

    public List<Registration> getRegistration() {
        return registration;
    }

    public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }
}
