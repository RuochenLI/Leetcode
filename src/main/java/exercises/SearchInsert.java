package exercises;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
