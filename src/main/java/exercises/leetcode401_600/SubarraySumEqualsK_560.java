package exercises.leetcode401_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

//    public int subarraySum(int[] nums, int k) {
//        int[] presum = new int[nums.length + 1];
//        Map<Integer, List<Integer>> hash = new HashMap<>();
//        int result = 0;
//
//        hash.put(0, Lists.newArrayList(0));
//        for (int i = 1; i <= nums.length; i++) {
//            presum[i] = presum[i - 1] + nums[i - 1];
//            List<Integer> index = hash.getOrDefault(presum[i], new ArrayList<>());
//            index.add(i);
//            hash.put(presum[i], index);
//        }
//
//        for (int i = 1; i <= nums.length; i++) {
//            int remain = presum[i] - k;
//            if (hash.containsKey(remain))
//                for (int index : hash.get(remain)) {
//                    if (index < i) result++;
//                }
//        }
//
//        return result;
//    }
}
