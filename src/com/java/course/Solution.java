package com.java.course;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static String[] resultArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> repeatWords = new HashMap<>();
        StringBuffer resultString = new StringBuffer();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("\\s+");

            if (line.isEmpty()) break;

            for (String word : words) {
                if (repeatWords.get(word) == null) {
                    repeatWords.put(word, 1);
                } else {
                    int prevValue = repeatWords.get(word) + 1;
                    repeatWords.put(word, prevValue);
                }
            }

            int maxEntry = 1;

            for (Map.Entry<String, Integer> entry : repeatWords.entrySet()) {
                if (entry.getValue() > maxEntry) {
                    resultString = new StringBuffer();
                    String tempResultString = entry.getKey() + " ";
                    maxEntry = entry.getValue();
                    resultString.append(tempResultString);
                } else if (entry.getValue() == maxEntry && entry.getValue() != 1) {
                    String tempResultString = entry.getKey() + " ";
                    resultString.append(tempResultString);
                }
            }

            if (resultString.length() > 0) {
                resultArray = resultString.toString().split(" ");
                Arrays.sort(resultArray);
            } else {
                resultArray = new String[]{""};
            }
        }

        for (String s : resultArray) System.out.println(s);
    }
}