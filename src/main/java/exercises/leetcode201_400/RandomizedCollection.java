package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> randomizedCollection;
    List<Integer> nums;
    Random random;

    public RandomizedCollection() {
        randomizedCollection = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contains = randomizedCollection.containsKey(val);
        Set<Integer> locationSet = randomizedCollection.getOrDefault(val, new HashSet<>());
        locationSet.add(nums.size());
        randomizedCollection.put(val, locationSet);
        nums.add(val);
        return !contains;
    }

    public boolean remove(int val) {
        if (!randomizedCollection.containsKey(val)) {
            return false;
        }

        Set<Integer> locations = randomizedCollection.get(val);
        int location = locations.iterator().next();
        locations.remove(location);
        if (location < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(location, last);
            Set<Integer> lastOneLocations = randomizedCollection.get(last);
            lastOneLocations.remove(nums.size() - 1);
            lastOneLocations.add(location);
        }
        if (locations.isEmpty()) {
            randomizedCollection.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
