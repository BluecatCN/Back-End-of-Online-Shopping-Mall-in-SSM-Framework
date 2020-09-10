package com.succulent.user.entity;
/**
 * 编写实体类，实现回应结果的设定
 */

public class UserOrder {

    private String id;
    private String uid;
    private Integer price;
    private String addressId;
    private Integer stat;
    private Integer date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddressId(String qndw6vgb6vxwlsrkt1o4cdbmi8put2km) {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
