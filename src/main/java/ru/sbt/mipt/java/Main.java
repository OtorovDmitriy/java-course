package ru.sbt.mipt.java;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        String[] phoneNumbers = {"923-12-12", "253-32-62"};
        Person person = new Person("Lisa", "Brons", phoneNumbers, "Moscow", "357-861");

        Converter converter = new Converter();

        converter.converterStrategy = new ConverterToJSON();
        String jsonResult = converter.addConverterStrategy(person);

        converter.converterStrategy = new ConverterToXML();
        String xmlResult = converter.addConverterStrategy(person);

        System.out.println(jsonResult);
        System.out.println(xmlResult);
    }
}