package exercises.leetcode801_1000;

public class MaximizeDistanceToClosestPerson_849 {
    public int maxDistToClosest(int[] seats) {
        int max = -1;
        int left = -1;
        int right = 0;
        while (right < seats.length) {
            if (seats[right] == 1) {
                if (left == -1 && right != 0) {
                    max = right;
                } else {
                    max = Math.max(max, (right - left) / 2);
                }
                left = right;
            }
            right++;
        }
        if (seats[seats.length - 1] == 0) max = Math.max(max, seats.length - 1 - left);
        return max;
    }
}
