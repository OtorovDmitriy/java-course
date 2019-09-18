package com.java.course;

import com.java.course.trade.types.Bond;
import com.java.course.trade.types.CommoditySpot;
import com.java.course.trade.types.FxSpot;
import com.java.course.trade.types.IrSwap;

public enum TradeType {
    FX_SPOT {
        @Override
        public Object CreateTrade(String tradeType, int tradePrice) {
            return new FxSpot(tradeType, tradePrice);
        }
    },
    BOND {
        @Override
        public Object CreateTrade(String tradeType, int tradePrice) {
            return new Bond(tradeType, tradePrice);
        }
    },
    COMMODITY_SPOT {
        @Override
        public Object CreateTrade(String tradeType, int tradePrice) {
            return new CommoditySpot(tradeType, tradePrice);
        }
    },
    IR_SWAP {
        @Override
        public Object CreateTrade(String tradeType, int tradePrice) {
            return new IrSwap(tradeType, tradePrice);
        }
    };

    public abstract Object CreateTrade(String tradeType, int tradePrice);
}