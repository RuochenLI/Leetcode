/**
 * Created by Ruochen on 23/01/2017.
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
      List<Integer> numList = new ArrayList<>();
      for (int num : nums) {
         numList.add(num);
      }
        
      for (int num : numList) {
         int indexOf = numList.indexOf(num);
         int lastIndexOf = numList.lastIndexOf(target - num);
         if (numList.contains(target - num) && lastIndexOf != indexOf) {
            return new int[]{ indexOf, lastIndexOf};
         }
      }
        
        return null;
    }
}
