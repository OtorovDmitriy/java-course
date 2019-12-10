package ru.sbt.mipt.java;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> first_map = new CountMapIml<>();
        CountMap<Integer> second_map = new CountMapIml<>();

        first_map.add(1);
        first_map.add(2);
        first_map.add(3);

        second_map.add(1);
        second_map.add(4);
        second_map.add(5);

        System.out.println(first_map.size());
        first_map.addAll(second_map);
        System.out.println(first_map.size());

        first_map.remove(2);
        first_map.remove(4);

        System.out.println(first_map);
    }
}