package com.succulent.goods.entity;

public enum GoodsStat {

    NORMAL(1);


    private int value;

    public int getValue() {
        return value;
    }

    GoodsStat(int value) {
        this.value = value;
    }

}
