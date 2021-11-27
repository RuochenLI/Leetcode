package google.interviews;

public class LongestSubStringWithAtMostKDistinctCharacters340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int count = k;
        int[] occurance = new int[58];
        int leftPointer = 0;
        int rightPointer = 0;
        int max = 0;
        while (rightPointer < s.length()) {
            int chatAtRightPointer = s.charAt(rightPointer) - 'A';
            int charAtLeftPointer = s.charAt(leftPointer) - 'A';
            if (count > 0 || occurance[chatAtRightPointer] > 0) {
                max = Math.max(max, rightPointer - leftPointer + 1);
                if (occurance[chatAtRightPointer] == 0) {
                    count--;
                }
                occurance[chatAtRightPointer]++;
                rightPointer++;
            } else {
                occurance[charAtLeftPointer]--;
                if (occurance[charAtLeftPointer] == 0) count++;
                leftPointer++;
            }
        }
        return max;
    }
}
