package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String images;
    private String fullname;
    private String email;
    private String phone;
    private int roleid;
    private Date createDate;
    private String address; 
    private String code;

    // Constructor đầy đủ
    public UserModel(int id, String username, String password, String images, String fullname, String email,
                     String phone, int roleid, Date createDate, String address, String code) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.images = images;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
        this.createDate = createDate;
        this.address = address;
        this.code = code;
    }
    public UserModel(int id, String username, String password, String images, String fullname, String email, String phone, int roleid, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.images = images;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
        this.createDate = createDate;
    }


    // Constructor không có ID và ngày tạo
    public UserModel(String username, String password, String images, String fullname, String email, String phone,
                     int roleid, String address, String code) {
        super();
        this.username = username;
        this.password = password;
        this.images = images;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
        this.address = address;
        this.code = code;
    }

    // Constructor không có password, dùng khi chỉ cập nhật thông tin
    public UserModel(String username, String images, String fullname, String email, String phone, int roleid,
                     String address, String code) {
        super();
        this.username = username;
        this.images = images;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;
        this.address = address;
        this.code = code;
    }

    // Constructor rỗng
    public UserModel() {
        super();
    }

    // Getter và Setter cho tất cả các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", images=" + images
                + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", roleid=" + roleid
                + ", createDate=" + createDate + ", address=" + address + ", code=" + code + "]";
    }
}
