package com.liu.dto;

/**
 * Created by liuneng on 2016/12/28.
 */
public class UserInfo {
    private Integer userId;
    private String tel;
    private String address;

    public Integer getUserId() {
        return userId;
    }

    public UserInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UserInfo setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "" +
                "userId=" + userId +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '\n';
    }
}
