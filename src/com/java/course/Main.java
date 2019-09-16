package com.java.course;

public class Main {

    public static void main(String[] args) {
        Person Tom = new Person("Tom", 22, Gender.MAN);
        Person Mary = new Person("Mary", 20, Gender.WOMAN);
        Person Kate = new Person("Kate", 21, Gender.WOMAN);
        Person Mike = new Person("Mike", 25, Gender.MAN);

        Tom.marry(Mary);
        Tom.marry(Kate);
        Mary.marry(Mike);

        System.out.println(Tom);
        System.out.println(Mary);
        System.out.println(Kate);
        System.out.println(Mike);
    }
}