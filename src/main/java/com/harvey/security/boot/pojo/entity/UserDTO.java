package com.harvey.security.boot.pojo.entity;

/**
 * 与数据表t_user连接的User实体类
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2023-12-18 20:38
 */
public class UserDTO {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    public UserDTO() {
    }

    public UserDTO(String id, String username, String password, String fullName, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullName;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
