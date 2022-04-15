package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i ++) {
            String binary = Integer.toBinaryString(i);
            List<Integer> element = new ArrayList<>();
            for (int j = 0; j < binary.toCharArray().length; j++) {
                char c = binary.charAt(j);
                if (c == '1') {
                    element.add(nums[nums.length - binary.length() + j]);
                }
            }
            result.add(element);
        }
        return result;
    }
}
