package com.succulent.goods.qo;

public class DuplicatedOrderGoodsCountQuery {

    private String uid;
    private String skuId;

    public DuplicatedOrderGoodsCountQuery(String uid, String skuId) {
        this.uid = uid;
        this.skuId = skuId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
}
