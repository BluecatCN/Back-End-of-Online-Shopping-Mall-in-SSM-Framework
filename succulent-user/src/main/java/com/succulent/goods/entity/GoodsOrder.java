package com.succulent.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.mall.user.lib.entity.UserInfo;
import com.succulent.user.entity.UserInfo;

import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class GoodsOrder {

    private String  id;
    private String  uid;
    private String  transId;
    private Integer amount;
    private Integer discount;
    private String  body;
    private String  comment;
    private Long date;
    private Integer stat;
    private Integer version;

    private UserInfo user;
    private List<OrderGoods> goodsList;

    public GoodsOrder() {
    }

    public GoodsOrder(String id) {
        this.id = id;
    }

    public GoodsOrder(String id, String uid, String transId) {
        this.id = id;
        this.uid = uid;
        this.transId = transId;
    }

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

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }
}
