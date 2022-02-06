package interviews.google;

public class NumSplits {
    public int numSplits(String s) {
        int[] rightCount = new int[26];
        boolean[] leftCount = new boolean[26];
        int leftFrequency = 0;
        int rightFrequency = 0;
        int result = 0;

        for (final char c : s.toCharArray()) {
            int ascii = c - 'a';
            rightCount[ascii]++;
            if (rightCount[ascii] == 1) rightFrequency++;
        }

        for (final char c : s.toCharArray()) {
            int ascii = c - 'a';
            rightCount[ascii]--;
            if (!leftCount[ascii]) {
                leftFrequency++;
                leftCount[ascii] = true;
            }
            if (rightCount[ascii] == 0) rightFrequency--;
            if (leftFrequency == rightFrequency) result++;
        }

        return result;
    }
}
