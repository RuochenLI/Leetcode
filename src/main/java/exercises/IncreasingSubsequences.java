package exercises;

import java.util.*;

/**
 * 491. Increasing Subsequences
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * Created by Ruochen on 21/01/2017.
 */
public final class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        findSolution(result, new ArrayList<>(), nums, 0);
        return new ArrayList<>(result);
    }

    public void findSolution(Set<List<Integer>> result, List<Integer> numList, int[] nums, int indicator) {
        if (numList.size() >= 2) {
            result.add(new ArrayList<>(numList));
        }

        for (int index = indicator; index < nums.length; index++) {
            if (numList.size() == 0 || numList.get(numList.size() - 1) <= nums[index]) {
                numList.add(nums[index]);
                findSolution(result, numList, nums, (index + 1));
                numList.remove((Integer) nums[index]);
            }
        }
    }

}
