package ru.sbt.mipt.java;

public interface ConverterStrategy {
    String serialize(Object o) throws IllegalAccessException;
}
