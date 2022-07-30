package exercises.leetcode1401_1600;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 */
public class MaximumPointsYouCanObtainfromCards_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int left = k - 1;
        int right = cardPoints.length - 1;
        while (left >= 0) {
            sum -= cardPoints[left--];
            sum += cardPoints[right--];
            max = Math.max(sum, max);
        }
        return max;
    }
}
