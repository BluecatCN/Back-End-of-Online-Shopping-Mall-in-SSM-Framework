package com.succulent.goods.entity;

public enum OrderStat {

    NORMAL(1);


    private int value;

    public int getValue() {
        return value;
    }

    OrderStat(int value) {
        this.value = value;
    }

}
