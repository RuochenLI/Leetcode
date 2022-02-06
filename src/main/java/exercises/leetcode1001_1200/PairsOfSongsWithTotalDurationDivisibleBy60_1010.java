package exercises.leetcode1001_1200;

public class PairsOfSongsWithTotalDurationDivisibleBy60_1010 {
    // public int numPairsDivisibleBy60(int[] time) {
    //     int count = 0;
    //     for (int i = 0; i < time.length - 1; i++) {
    //         for (int j = i + 1; j < time.length; j++) {
    //             if ((time[i] + time[j]) % 60 == 0)
    //                 count++;
    //         }
    //     }
    //     return count;
    // }

    public int numPairsDivisibleBy60(int[] time) {
        int[] occurance = new int[60];
        for (int duration : time) {
            occurance[duration % 60]++;
        }
        int count = 0;
        if (occurance[30] > 1) count += findPairs(occurance[30]);
        if (occurance[0] > 1) count += findPairs(occurance[0]);
        for (int i = 1; i <= 29; i++) {
            if (occurance[i] > 0) {
                count += occurance[60 - i] * occurance[i];
            }
        }
        return count;
    }

    public int findPairs(int n){
        return n*(n-1)/2;
    }
}
