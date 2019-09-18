package com.java.course.trade.types;

public class Bond {
    private String tradeType;
    private int tradePrice;

    public Bond(String tradeType, int tradePrice) {
        this.tradeType = tradeType;
        this.tradePrice = tradePrice;
    }

    Bond(int tradePrice) {
        this.tradeType = "BOND";
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [tradeType:" + tradeType + " tradePrice:" + tradePrice + "]";
    }
}