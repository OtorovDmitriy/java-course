package com.java.course;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.course.trade.types.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Add a file name or enter data in the console (one line).");

        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();

        File file = new File("./", nextLine);

        ArrayList<String> tradeType = new ArrayList<>();
        ArrayList<String> tradePrice = new ArrayList<>();
        ArrayList<Object> tradeObjects = new ArrayList<>();

        if (file.exists()) {
            String line;

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                getTradeData(line, tradeType, tradePrice);
            }
        } else {
            getTradeData(nextLine, tradeType, tradePrice);
        }

        if ((tradeType.size() > 0 && tradePrice.size() > 0) && (tradeType.size() == tradePrice.size())) {
            for (int i = 0; i < tradeType.size(); i++) {
                String tradeTypeValue = tradeType.get(i);
                int tradePriceValue = Integer.parseInt(tradePrice.get(i));
                Object tradeObject;

                // First method
                // switch (tradeTypeValue) {
                //     case "FX_SPOT":
                //         tradeObject = new FxSpot(tradeTypeValue, tradePriceValue);
                //         tradeObjects.add(tradeObject);
                //         break;
                //     case "BOND":
                //         tradeObject = new Bond(tradeTypeValue, tradePriceValue);
                //         tradeObjects.add(tradeObject);
                //         break;
                //     case "COMMODITY_SPOT":
                //         tradeObject = new CommoditySpot(tradeTypeValue, tradePriceValue);
                //         tradeObjects.add(tradeObject);
                //         break;
                //     case "IR_SWAP":
                //         tradeObject = new IrSwap(tradeTypeValue, tradePriceValue);
                //         tradeObjects.add(tradeObject);
                //         break;
                //     default:
                //         System.out.println(tradeTypeValue + " type not found");
                // }

                // Second method
                tradeObject = TradeType.valueOf(tradeTypeValue).CreateTrade(tradeTypeValue, tradePriceValue);
                tradeObjects.add(tradeObject);
            }

            if (tradeObjects.size() > 0) {
                for (Object tradeObject : tradeObjects) {
                    System.out.println(tradeObject);
                }
            }
        } else {
            System.out.println("Please add valid data.");
        }
    }

    private static void getTradeData(String line, ArrayList<String> tradeType, ArrayList<String> tradePrice) {
        Pattern patternCS = Pattern.compile("type=\\{[A-Z|_]+}|price=\\{[0-9|.,_]+}");
        Matcher matcher = patternCS.matcher(line);

        while (matcher.find()) {
            String valueWithType = line.substring(matcher.start(), matcher.end());
            String value = valueWithType.substring(valueWithType.indexOf("{") + 1, valueWithType.lastIndexOf("}"));
            if (valueWithType.contains("type")) {
                tradeType.add(value.toUpperCase());
            } else if (valueWithType.contains("price")) {
                tradePrice.add(value);
            }
        }
    }
}