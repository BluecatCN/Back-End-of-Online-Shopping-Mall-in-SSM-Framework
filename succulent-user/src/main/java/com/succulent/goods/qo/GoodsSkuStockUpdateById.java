package com.succulent.goods.qo;

public class GoodsSkuStockUpdateById {

    private String id;
    private Integer quantity;
    private Integer version;

    public GoodsSkuStockUpdateById(String id, Integer quantity, Integer version) {
        this.id = id;
        this.quantity = quantity;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
