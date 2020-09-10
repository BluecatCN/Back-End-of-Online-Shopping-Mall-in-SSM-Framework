package com.succulent.user.entity;

public class UserBalance {

    private String uid;
    private Integer value;
    private Integer stat;

    public UserBalance() {

    }
    public UserBalance(String uid, Integer value) {
        this.uid = uid;
        this.value = value;
    }

    public UserBalance(String uid, Integer value, Integer stat) {
        this.uid = uid;
        this.value = value;
        this.stat = stat;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer addedStat(){return stat;}

    public void setAddedStat(Integer stat){this.stat=stat+value;}


    public Integer subtractedStat(){return stat;}

    public void setSubtractedStat(Integer stat){this.stat=stat-value;}
}
