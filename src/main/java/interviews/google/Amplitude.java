package interviews.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Amplitude {
    /**
    Given an Array A, find the minimum amplitude you can get after changing up to 3 elements. Amplitude is the range of the array (basically difference between largest and smallest element).
     LeetCode: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
     https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
     **/

    int moves;
    Amplitude(){
        this.moves = 3;
    }

    public int minDifference(int[] nums) {
        if(nums == null || nums.length <= 4){
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<=moves;i++){
            min = Math.min(min,nums[length-1-i]- nums[moves-i]);
        }
        return min;
    }

    private static int minAmplitude2(int[] nums) {
        if(nums.length <= 4) return 0;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            maxQueue.add(n);
            if(maxQueue.size() > 4) maxQueue.poll();
            minQueue.add(n);
            if(minQueue.size() > 4) minQueue.poll();
        }
        List<Integer> maxList = new ArrayList<>();
        while(maxQueue.size() > 0) maxList.add(maxQueue.poll());
        List<Integer> minList = new ArrayList<>();
        while(minQueue.size() > 0) minList.add(minQueue.poll());
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(3-i));
        }
        return ans;
    }

}
