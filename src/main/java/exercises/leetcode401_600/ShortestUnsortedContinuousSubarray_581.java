package exercises.leetcode401_600;

public class ShortestUnsortedContinuousSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0;

        int lp = 0;
        while (lp < nums.length - 1 && nums[lp] <= nums[lp + 1]) {
            lp++;
        }

        if (lp == nums.length - 1) return 0;

        int max = nums[lp];
        int indexLeft = lp;

        int rp = nums.length - 1;
        while (rp > 0 && nums[rp] >= nums[rp - 1]) {
            rp--;
        }

        int min = nums[rp];
        int indexRight = rp;

        for (int i = indexLeft; i <= indexRight; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int p = 0;
        while (p <= indexLeft && nums[p] <= min) p++;
        indexLeft = p;

        p = nums.length - 1;
        while (p > indexRight && nums[p] >= max) p--;
        indexRight = p;

        return indexRight - indexLeft + 1;
    }
}
