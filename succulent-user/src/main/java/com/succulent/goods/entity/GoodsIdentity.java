package com.succulent.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.mall.lib.file.FileServer;
//import com.mall.lib.file.spec.FileSpecGoods;
//import com.mall.lib.qo.Pageable;

import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Data
//
//@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class GoodsIdentity {

    private String id;
    private String title;
    private String cover;
    private Integer discount;
    private String intro;
    private Integer type;
    private String categoryId;
    private Integer seq;
    private Integer stat;
    private Integer date;

    private String dateStart;
    private String dateEnd;
    private String subject;
    private String address;

    private List<GoodsSku> skus;

    public GoodsIdentity() {
    }

    public GoodsIdentity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public List<GoodsSku> getSkus() {
        return skus;
    }

    public void setSkus(List<GoodsSku> skus) {
        this.skus = skus;
    }

//    public String getCoverUrl() {
//        return FileServer.getFileUrl(FileSpecGoods.COVER, this.cover);
//    }

    public String getDateStart() {
        return dateStart;
    }

    public GoodsIdentity setDateStart(String dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public GoodsIdentity setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public GoodsIdentity setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public GoodsIdentity setAddress(String address) {
        this.address = address;
        return this;
    }

//    public void setUid(String user) {
//        this.user=user;
//        return this;
//    }
}
