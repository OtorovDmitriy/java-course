package ru.sbt.mipt.java;

class Converter {
    ConverterStrategy converterStrategy;

    String addConverterStrategy(Object o) throws IllegalAccessException {
        return this.converterStrategy.serialize(o);
    }
}
