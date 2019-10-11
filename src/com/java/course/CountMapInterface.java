package com.java.course;

import java.util.Map;

interface CountMapInterface<K> {
    void add(K key);
    int getCount(K key);
    int remove(K key);
    int size();
    void addAll(CountMap source);
    Map toMap();
    // void toMap(Map destination);
}