package challenge.year2020.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        int curMax = A[0];
        int max = A[0];
        int curMin = A[0];
        int min = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            curMax = A[i] + Math.max(curMax, 0);
            max = Math.max(curMax, max);
            curMin = A[i] + Math.min(curMin, 0);
            min = Math.min(curMin, min);
        }
        if (max < 0)
            return max;
        return Math.max(sum - min, max);
    }

    public int maxSubarraySumCircular1(int[] A) {
        if (A.length == 1) return A[0];
        int maxInArray = Arrays.stream(A).max().getAsInt();
        if (maxInArray < 0) return maxInArray;
        int max = A[0];
        List<Integer> startPoints = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int negativeSum = 0;
        int positiveSum = 0;
        for (int index = 0; index < A.length; index++) {
            if (A[index] < 0) {
                if (positiveSum != 0) {
                    nums.add(positiveSum);
                    positiveSum = 0;
                }
                negativeSum = negativeSum + A[index];
            } else if (A[index] > 0) {
                if (negativeSum != 0) {
                    nums.add(negativeSum);
                    negativeSum = 0;
                    startPoints.add(nums.size() - 1);
                }
                positiveSum = positiveSum + A[index];
            }
        }
        if (A[A.length - 1] < 0) {
            nums.add(negativeSum);
            startPoints.add(nums.size() - 1);
        } else {
            nums.add(positiveSum);
        }
        if (startPoints.isEmpty()) startPoints.add(0);
        for (final int startPoint : startPoints) {
            int pointer = startPoint + 1;
            int subsum = Math.max(nums.get(startPoint), 0);
            max = Math.max(max, subsum);
            while (pointer != startPoint) {
                if (pointer == nums.size()) pointer = 0;
                if (pointer == startPoint) break;
                subsum = subsum + nums.get(pointer);
                if (subsum > max) {
                    max = subsum;
                }
                if (subsum < 0) {
                    subsum = 0;
                }
                pointer++;
            }
        }

        return max;
    }
}
