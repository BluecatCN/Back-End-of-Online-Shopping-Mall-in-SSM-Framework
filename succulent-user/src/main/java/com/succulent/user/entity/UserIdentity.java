package com.succulent.user.entity;

public class UserIdentity {
    private String id;
    private String wxOpenId;
    private String wxUnionId;
    private String phone;
    private String passcode;
    private String token;
    private String stat;
    private String idCode;
    private Integer date;

    public UserIdentity() {
    }

    public UserIdentity(String id, String wxOpenId, String wxUnionId, String phone, String passcode, String token, String stat, String idCode, Integer date) {
        this.id = id;
        this.wxOpenId = wxOpenId;
        this.wxUnionId = wxUnionId;
        this.phone = phone;
        this.passcode = passcode;
        this.token = token;
        this.stat = stat;
        this.idCode = idCode;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
