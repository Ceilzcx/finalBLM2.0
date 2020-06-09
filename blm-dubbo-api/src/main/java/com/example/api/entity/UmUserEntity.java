package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "um_user", schema = "blm", catalog = "")
public class UmUserEntity implements Serializable {
    private Integer userId;
    private String userName;
    private String userAccount;
    @JsonIgnore
    private String userPwd;
    private String userTel;
    private String userAddress;
    private byte[] userImage;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_account", nullable = true, length = 100)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "user_pwd", nullable = true, length = 50)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_tel", nullable = true, length = 20)
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Basic
    @Column(name = "user_address", nullable = true, length = 100)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "user_image", nullable = true)
    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UmUserEntity that = (UmUserEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount!= null) return false;
        if (userPwd != null ? !userPwd.equals(that.userPwd) : that.userPwd != null) return false;
        if (userTel != null ? !userTel.equals(that.userTel) : that.userTel != null) return false;
        if (userAddress != null ? !userAddress.equals(that.userAddress) : that.userAddress != null) return false;
        if (!Arrays.equals(userImage, that.userImage)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(userImage);
        return result;
    }
}
