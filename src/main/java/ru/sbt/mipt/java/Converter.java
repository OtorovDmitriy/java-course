package ru.sbt.mipt.java;

public interface Converter {
    String serialize(Object o) throws IllegalAccessException;
}
