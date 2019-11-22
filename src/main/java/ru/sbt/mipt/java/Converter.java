package ru.sbt.mipt.java;

public class Converter implements ConverterInterface {
    private Person person;

    Converter(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String serialize(Object o) throws IllegalAccessException {
        return null;
    }
}
