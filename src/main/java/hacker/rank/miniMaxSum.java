package hacker.rank;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class miniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
//        Collections.sort(arr);
//        long min = arr.get(0) + arr.get(1) + arr.get(2) + arr.get(3);
//        int length = arr.size();
//        long max = arr.get(length - 1) + arr.get(length - 2) + arr.get(length - 3) + arr.get(length - 4);
//        System.out.println(min + " " + max);

        long sumMax = 0; long max = Integer.MIN_VALUE; long min = Integer.MAX_VALUE; long sumMin = 0;
        for(Integer i: arr) {
            if(i <= min){
                min = i;
            }
            if (i >= max){
                max = i;
            }
        }
        for(Integer j: arr){
            if(min != j){
                sumMax += j;
            }
            if(max != j){
                sumMin += j;
            }
            if(min == max){
                sumMax = sumMin = (min * (arr.size()-1));
            }
        }
        System.out.println(sumMin + " " + sumMax);

    }

}
