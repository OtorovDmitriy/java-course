package com.java.course;

import java.util.HashMap;
import java.util.Map;

public class CountMap<K> implements CountMapInterface<K> {
    private HashMap<K, Integer> hashMap = new HashMap<>();

    @Override
    public void add(K key) {
        if (this.hashMap.containsKey(key)) {
            this.hashMap.put(key, this.hashMap.get(key) + 1);
        } else {
            this.hashMap.put(key, 1);
        }
    }

    @Override
    public int getCount(K key) {
        return this.hashMap.get(key);
    }

    @Override
    public int remove(K key) {
        int entriesNum = this.hashMap.get(key);
        this.hashMap.remove(key);
        return (entriesNum);
    }

    @Override
    public int size() {
        return this.hashMap.size();
    }

    @Override
    public void addAll(CountMap source) {
        source.hashMap.forEach((k, v) -> {
            int entriesNum = (int) source.hashMap.get(k);
            for (int i = 0; i < entriesNum; i++) {
                this.add((K) k);
            }
        });
    }

    @Override
    public Map toMap() {
        return this.hashMap;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        this.hashMap.forEach((k, v) -> {
            int entriesNum = (int) this.hashMap.get(k);
            result.append(k).append(": ").append(entriesNum).append("\n");
        });

        return String.valueOf(result);
    }
}