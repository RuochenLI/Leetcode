package exercises.leetcode1_200;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int firstDescend = nums.length - 2;
        while (firstDescend >= 0 && nums[firstDescend] >= nums[firstDescend + 1]) {
            firstDescend--;
        }

        if (firstDescend >= 0) {
            int bigger = nums[firstDescend + 1];
            int index = firstDescend + 1;
            for (int i = firstDescend + 2; i < nums.length; i++) {
                if (nums[i] > nums[firstDescend] && nums[i] <= bigger) {
                    bigger = nums[i];
                    index = i;
                }
            }
            swap(nums, firstDescend, index);
        }
        reverse(nums, firstDescend + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
