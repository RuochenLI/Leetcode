package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(missingRange(lower, upper));
            return result;
        }

        int pointer = 0;
        if (lower < nums[0]) {
            result.add(missingRange(lower, nums[0] - 1));
        }

        while (pointer < nums.length - 1) {
            if (nums[pointer] != nums[pointer + 1] && nums[pointer] != nums[pointer + 1] - 1) {
                result.add(missingRange(nums[pointer] + 1, nums[pointer + 1] - 1));
            }
            pointer++;
        }
        if (nums[nums.length - 1] < upper) {
            result.add(missingRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    public String missingRange(int low, int up) {
        if (low == up) {
            return String.valueOf(low);
        } else {
            return low + "->" + up;
        }
    }
}
