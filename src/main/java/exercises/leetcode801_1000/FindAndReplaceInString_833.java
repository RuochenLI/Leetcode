package exercises.leetcode801_1000;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 833. Find And Replace in String
 */
public class FindAndReplaceInString_833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int pt = 0;
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, String[]> indiceMap = new TreeMap<>();

        for (int i = 0; i < indices.length; i++) {
            indiceMap.put(indices[i], new String[]{sources[i], targets[i]});
        }

        Iterator<Map.Entry<Integer, String[]>> iterator = indiceMap.entrySet().iterator();
        while (pt < s.length() && iterator.hasNext()) {
            Map.Entry<Integer, String[]> entry = iterator.next();
            if (pt < entry.getKey()) {
                sb.append(s, pt, entry.getKey());
                pt = entry.getKey();
            }

            if (pt > entry.getKey()) {
                continue;
            }

            String source = entry.getValue()[0];
            String expected = s.substring(pt, pt + source.length());
            if (source.equals(expected)) {
                sb.append(entry.getValue()[1]);
            } else {
                sb.append(expected);
            }
            pt += source.length();
        }

        if (pt < s.length()) {
            sb.append(s.substring(pt));
        }

        return sb.toString();
    }
}
