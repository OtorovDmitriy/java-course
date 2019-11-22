package ru.sbt.mipt.java;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConverterToJSON extends Converter {

    ConverterToJSON(Person person) {
        super(person);
    }

    @Override
    public String serialize(Object o) throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Object value = field.get(o);
            Class type = field.getType();

            if (type.isPrimitive() || type == String.class) {
                jsonObject.put(field.getName(), value);
            } else if (type == String[].class) {
                String array = Arrays.toString((String[]) value);
                jsonObject.put(field.getName(), new JSONArray(array));
            } else {
                String tempResultString = this.serialize(value);
                jsonObject.put(field.getName(), new JSONObject(tempResultString));
            }
        }
        return jsonObject.toString();
    }
}
