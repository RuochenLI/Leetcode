import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruochen on 08/03/2017.
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {

        int result =0;
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int num : nums) {
           occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }

        if (k < 0) {
            return 0;
        }

        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1)
                    result++;
                continue;
            }

            if (occurrence.containsKey(entry.getKey() + k)) {
                result++;
            }
        }

        return result;
    }
}
