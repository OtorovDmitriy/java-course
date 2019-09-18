package com.java.course.trade.types;

public class CommoditySpot {
    private String tradeType;
    private int tradePrice;

    public CommoditySpot(String tradeType, int tradePrice) {
        this.tradeType = tradeType;
        this.tradePrice = tradePrice;
    }

    CommoditySpot(int tradePrice) {
        this.tradeType = "BOND";
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [tradeType:" + tradeType + " tradePrice:" + tradePrice + "]";
    }
}