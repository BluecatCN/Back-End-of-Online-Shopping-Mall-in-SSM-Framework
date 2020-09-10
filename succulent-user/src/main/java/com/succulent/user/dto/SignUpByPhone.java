package com.succulent.user.dto;

/**
 * 注册，输入数据：手机
 */

public class SignUpByPhone {

    private String phone;
    private String passcode;

    public String getPhone() {
        return phone;
    }
    public String getPasscode() {
        return passcode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}
