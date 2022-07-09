package exercises.leetcode2001_2200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2178. Maximum Split of Positive Even Integers
 */
public class MaximumSplitOfPositiveEvenIntegers_2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }

        long presum = 0;
        LinkedList<Long> result = new LinkedList<>();
        for (long i = 2; presum + i <= finalSum; i += 2) {
            presum += i;
            result.push(i);
        }
        if (presum == finalSum) {
            return result;
        }

        result.push(finalSum - presum + result.pop());
        return result;
    }
}
