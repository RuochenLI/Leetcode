package exercises.leetcode1401_1600;

/**
 * 1554. Strings Differ by One Character
 */
public class StringDifferByOneCharacter_1554 {
    public boolean differByOne(String[] dict) {
        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = i +1; j < dict.length; j++) {
                int count = 0;
                int pt = 0;
                while (pt < dict[i].length() && count < 2) {
                    if (dict[i].charAt(pt) != dict[j].charAt(pt)) {
                        count++;
                    }
                    pt++;
                }
                if (count == 1) return true;
            }
        }
        return false;
    }
}
