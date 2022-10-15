package exercises.leetcode201_400;

import java.util.Arrays;

/**
 * 274. H-Index
 */
public class HIndex_274 {
    // count sort
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c : citations) {
            papers[Math.min(n, c)]++;
        }
        // finding the h-index
        int hIndex = n;
        int countSum = papers[n];
        while (hIndex > countSum) {
            hIndex--;
            countSum += papers[hIndex];
        }
        return hIndex;
    }

    public int hIndex0(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }
}
