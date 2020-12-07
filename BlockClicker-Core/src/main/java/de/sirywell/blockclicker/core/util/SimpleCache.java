package de.sirywell.blockclicker.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public SimpleCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
