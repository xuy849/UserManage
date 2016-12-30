package com.liu.dto;

import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Created by liuneng on 2016/12/28.
 */
public class User {
    @NotNull
    private Integer id;
    private String firstName;
    private String lastName;
    private Date lastUpdatedTime;
    private UserInfo userInfo;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public User setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        return this;
    }

    @Override
    public String toString() {
        return "" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", userInfo=" + userInfo +
                '\n';
    }
}
