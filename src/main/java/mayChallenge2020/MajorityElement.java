package mayChallenge2020;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement1(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<>();
        int target = nums.length / 2;
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.computeIfPresent(num, (key, value) -> ++value);
            } else {
                numMap.put(num, 1);
            }
            if (numMap.get(num) > target)
                return num;
        }
        return -1;
    }

    //niu bi solution, copy from others' solution
    public static int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
