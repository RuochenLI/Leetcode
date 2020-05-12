package challenge.year2020.may;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (start == end) return nums[start];
            if (nums[start] != nums[start + 1]) return nums[start];
            if (nums[end] != nums[end - 1]) return nums[end];
            int medium = start + (end - start) / 2;
            if (nums[medium] != nums[medium - 1] && nums[medium] != nums[medium + 1]) return nums[medium];

            if (medium % 2 == 0) {
                if (nums[medium] == nums[medium - 1]) {
                    end = medium - 2;
                    continue;
                }

                start = medium + 2;
                continue;
            }

            if (nums[medium] == nums[medium - 1]) {
                start = medium + +1;
                continue;
            }

            end = medium - 1;
        }

        return -1;
    }
}
