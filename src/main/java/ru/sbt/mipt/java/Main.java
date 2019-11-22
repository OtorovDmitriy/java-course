package ru.sbt.mipt.java;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        String[] phoneNumbers = {"923-12-12", "253-32-62"};
        Person person = new Person("Lisa", "Brons", phoneNumbers, "Moscow", "357-861");
        ConverterToJSON converterToJSON = new ConverterToJSON(person);
        String jsonResult = converterToJSON.serialize(person);
        System.out.println(jsonResult);
    }
}
