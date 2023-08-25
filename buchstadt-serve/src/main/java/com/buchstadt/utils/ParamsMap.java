package com.buchstadt.utils;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class ParamsMap<K, V> {

    private final HashMap<K, V> map;

    public ParamsMap() {
        this.map = new HashMap<>();
    }

    public ParamsMap<K, V> set(K k, V v) {
        map.put(k, v);
        return this;
    }

}
