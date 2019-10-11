package com.java.course;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> map_first = new CountMap<>();
        CountMap<Integer> map_second = new CountMap<>();
        map_first.add(1);
        map_first.add(2);
        map_second.add(3);
        map_second.add(5);
        map_second.add(5);

        System.out.println(map_first.size());
        map_first.addAll(map_second);
        System.out.println(map_first.size());

        System.out.println(map_first);

        // System.out.println((map_first.getCount(1)));
    }
}