package com.java.course.trade.types;

public class IrSwap {
    private String tradeType;
    private int tradePrice;

    public IrSwap(String tradeType, int tradePrice) {
        this.tradeType = tradeType;
        this.tradePrice = tradePrice;
    }

    IrSwap(int tradePrice) {
        this.tradeType = "BOND";
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [tradeType:" + tradeType + " tradePrice:" + tradePrice + "]";
    }
}