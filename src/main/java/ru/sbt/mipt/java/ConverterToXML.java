package ru.sbt.mipt.java;

import org.json.JSONObject;
import org.json.XML;

public class ConverterToXML implements ConverterStrategy {

    @Override
    public String serialize(Object o) throws IllegalAccessException {
        String className = o.getClass().getSimpleName();
        String jsonString = new ConverterToJSON().serialize(o);
        JSONObject jsonObject = new JSONObject(jsonString);
        String xmlString = XML.toString(jsonObject);
        return String.format("<%s>%s</%s>", className, xmlString, className);
    }
}