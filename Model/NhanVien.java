package Model;

import java.util.Date;

public class NhanVien {
    private int id;
    private String name;
    private String birthday;
    private String address;
    private String sdt;
    private String email;
    private String department;
    public NhanVien(){

    }

    public NhanVien(int id, String name, String birthday, String address, String sdt, String email, String department) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.sdt = sdt;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
