package exercises.leetcode801_1000;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.base.Strings;

public class TimeMap {
    private final Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!this.store.containsKey(key)) {
            return null;
        }


        TreeMap<Integer, String> timestampMap = this.store.get(key);
        Integer timestampKey = timestampMap.floorKey(timestamp);
        if (timestampKey == null || Strings.isNullOrEmpty(timestampMap.get(timestampKey))) {
            return null;
        }

        return timestampMap.get(timestampKey);
    }
}
