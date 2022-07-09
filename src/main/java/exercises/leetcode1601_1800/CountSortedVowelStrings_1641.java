package exercises.leetcode1601_1800;

public class CountSortedVowelStrings_1641 {
    public int countVowelStrings(int n) {
        int[][] result = new int[n + 1][5];

        result[1][0] = 1;
        result[1][1] = 1;
        result[1][2] = 1;
        result[1][3] = 1;
        result[1][4] = 1;

        for (int i = 2; i <= n; i++) {
            result[i][0] = result[i - 1][0];
            for (int j = 1; j < 5; j++) {
                result[i][j] = result[i][j - 1] + result[i - 1][j];
            }
        }

        return result[n][0] + result[n][1] + result[n][2] + result[n][3] + result[n][4];
    }
}
