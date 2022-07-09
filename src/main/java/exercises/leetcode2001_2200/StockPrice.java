package exercises.leetcode2001_2200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StockPrice {
    Map<Integer, Integer> timeMap;
    TreeMap<Integer, Set<Integer>> priceMap;
    int current;

    public StockPrice() {
        this.timeMap = new HashMap<>();
        this.priceMap = new TreeMap<>();
        this.current = -1;
    }

    public void update(int timestamp, int price) {
        if (timestamp > this.current) {
            this.current = timestamp;
        } else {
            if (timeMap.containsKey(timestamp)) {
                Integer currentValue = this.timeMap.get(timestamp);
                System.out.println(currentValue);
                Set<Integer> times = this.priceMap.get(currentValue);
                times.remove(timestamp);
                if (times.isEmpty()) {
                    this.priceMap.remove(currentValue);
                }
            }
        }
        this.timeMap.put(timestamp, price);
        this.priceMap.computeIfAbsent(price, k -> new HashSet<>()).add(timestamp);
    }

    public int current() {
        return this.timeMap.get(this.current);
    }

    public int maximum() {
        return this.priceMap.lastKey();
    }

    public int minimum() {
        return this.priceMap.firstKey();
    }
}
