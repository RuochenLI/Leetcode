package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    Map<Integer, Integer> randomizedSet;
    List<Integer> nums;
    Random random;

    public RandomizedSet() {
        randomizedSet = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (randomizedSet.containsKey(val)) {
            return false;
        }

        randomizedSet.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!randomizedSet.containsKey(val)) {
            return false;
        }

        int location = randomizedSet.get(val);
        if (location < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(location, last);
            randomizedSet.put(last, location);
        }
        randomizedSet.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
