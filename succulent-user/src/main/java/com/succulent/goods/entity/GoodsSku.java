package com.succulent.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//商品的颜色等特定附属属性，会影响价格等
@JsonIgnoreProperties(value = {"handler"})
public class GoodsSku {

    private String id;
    private String goodsId;
    private Integer price;
    private Integer stock;
    private Integer version;

    public GoodsSku() {
    }

    public GoodsSku(String id, String goodsId, Integer price, Integer stock) {
        this.id = id;
        this.goodsId = goodsId;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
