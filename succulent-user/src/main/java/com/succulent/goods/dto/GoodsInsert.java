package com.succulent.goods.dto;


import com.succulent.goods.entity.GoodsIdentity;
import com.succulent.goods.entity.GoodsSku;
import org.springframework.web.multipart.MultipartFile;

public class GoodsInsert extends GoodsIdentity {

    private MultipartFile coverFile;
    private String  skuId;
    private Integer price;
    private Integer stock;

    public GoodsSku toInsertSku(String skuId) {
        return new GoodsSku(skuId, super.getId(), price, stock);
    }

    public GoodsSku toUpdateSku() {
        if (skuId != null && (price != null || stock != null))
            return new GoodsSku(skuId, super.getId(), price, stock);
        return null;
    }

    public MultipartFile getCoverFile() {
        return coverFile;
    }

    public void setCoverFile(MultipartFile coverFile) {
        this.coverFile = coverFile;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
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

}
