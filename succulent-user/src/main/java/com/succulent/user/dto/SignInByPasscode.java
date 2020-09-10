package com.succulent.user.dto;

/**
 * 负责数据库的存取数据操作工作
 * 获取内部数据：手机，密码
 * model层
 */
public class SignInByPasscode {

    private String phone;
    private String passcode;

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
}
