package com.java.course;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        map.put("hello", 1);
        map.put("world", 2);
        System.out.println(map.get("hello"));
        System.out.println(map.remove("hello"));
        System.out.println(map.contains("world"));
        System.out.println(map.size());
    }
}