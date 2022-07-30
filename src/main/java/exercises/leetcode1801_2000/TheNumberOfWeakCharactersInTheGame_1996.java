package exercises.leetcode1801_2000;

import java.util.Arrays;

/**
 * 1996. The Number of Weak Characters in the Game
 */
public class TheNumberOfWeakCharactersInTheGame_1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        // sorting
        int n = properties.length;
        int count = 0;

        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        // [[10,4],[4,3],[1,2],[1,2],[1,3],[1,5]]...

        int max = 0;
        for (final int[] property : properties) {

            if (property[1] < max) {
                count++;
            }
            max = Math.max(max, property[1]);
        }
        return count;
    }
}
