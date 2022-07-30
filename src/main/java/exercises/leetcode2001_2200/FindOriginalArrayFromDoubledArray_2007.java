package exercises.leetcode2001_2200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2007. Find Original Array From Doubled Array
 */
public class FindOriginalArrayFromDoubledArray_2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }

        int[] result = new int[changed.length / 2];
        Arrays.sort(changed);
        int count = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            if (changed[i] % 2 == 0 && numMap.containsKey(changed[i] / 2)) {
                int num = changed[i] / 2;
                int occ = numMap.get(num) - 1;
                if (occ == 0) {
                    numMap.remove(num);
                } else {
                    numMap.put(num, occ);
                }
                result[count++] = num;
            } else {
                numMap.put(changed[i], numMap.getOrDefault(changed[i], 0) + 1);
            }
        }
        if (numMap.size() == 0) {
            return result;
        } else {
            return new int[]{};
        }
    }
}
