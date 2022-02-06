package exercises.leetcode801_1000;

public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int reachTop = -1;
        for (int i = 1; i < arr.length; i++) {
            if (i != 1 && arr[i - 1] > arr[i] && reachTop == -1) {
                reachTop = 1;
            } else {
                if ((arr[i - 1] - arr[i]) * reachTop <= 0)
                    return false;
            }
        }
        return reachTop != -1;
    }
}
