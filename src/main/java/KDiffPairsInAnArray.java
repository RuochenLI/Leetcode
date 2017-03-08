import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ruochen on 08/03/2017.
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Pair pair = new Pair(nums[i], nums[j]);
                if (Math.abs(nums[i] - nums[j]) == k && !pairs.contains(pair)) {
                    pairs.add(pair);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static final class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = Math.max(a, b);
            this.b = a + b - this.a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }

    /*
    网友给出的O(n)的算法
     */
    public int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
