package exercises.leetcode801_1000;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int lp = 0;
        int rp = nums.length - 1;
        while (lp < rp) {
            if (nums[lp] % 2 == 0) {
                lp++;
            } else if (nums[rp] % 2 == 1) {
                rp--;
            } else {
                int tmp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = tmp;
                lp++;
                rp--;
            }
        }
        return nums;
    }
}
