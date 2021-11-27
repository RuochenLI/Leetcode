package challenge.year2021;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final boolean[] occ = new boolean[nums.length + 1];
        final List<Integer> ans = new ArrayList();
        for (final int num : nums) {
            if (num <= nums.length) occ[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!occ[i]) ans.add(i);
        }

        return ans;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        final List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = nums[index] * (-1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) ans.add(i);
        }

        return ans;
    }

}
