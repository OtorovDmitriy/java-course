package com.java.course.trade.types;

public class FxSpot {
    private String tradeType;
    private int tradePrice;

    public FxSpot(String tradeType, int tradePrice) {
        this.tradeType = tradeType;
        this.tradePrice = tradePrice;
    }

    FxSpot(int tradePrice) {
        this.tradeType = "BOND";
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [tradeType:" + tradeType + " tradePrice:" + tradePrice + "]";
    }
}