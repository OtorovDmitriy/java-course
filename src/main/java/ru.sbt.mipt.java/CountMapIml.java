package ru.sbt.mipt.java;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<K> implements CountMap<K> {
    private HashMap<K, Integer> hashMap = new HashMap<>();

    @Override
    public void add(K key) {
        if (hashMap.containsKey(key)) {
            hashMap.replace(key, getCount(key) + 1);
        } else {
            hashMap.put(key, 1);
        }
    }

    @Override
    public int getCount(K key) {
        return hashMap.get(key);
    }

    @Override
    public int remove(K key) {
        return hashMap.remove(key);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public void addAll(CountMap source) {
        Map<K, Integer> map = source.toMap();

        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            K key = entry.getKey();
            Integer integer = entry.getValue();

            if (hashMap.containsKey(key)) {
                hashMap.replace(key, getCount(key) + integer);
            } else {
                hashMap.put(key, integer);
            }
        }
    }

    @Override
    public Map<K, Integer> toMap() {
        return hashMap;
    }

    @Override
    public void toMap(Map destination) {
        destination.clear();

        for (K key : hashMap.keySet()) {
            destination.put(key, getCount(key));
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();

        hashMap.forEach((key, value) -> {
            int entriesNum = getCount(key);
            result.append(key).append(": ").append(entriesNum).append("\n");
        });

        return String.valueOf(result);
    }
}
