package google.interviews;

public class MatricBlockSum {
    /**
     * ans[i][j] = ans[i - 1][j] + columnSum[i + k][j] - columnSum[i - k][j]
     * columnSum[i][j] = columnSum[i][j - 1] + mat[i][j + k] - mat[i][j - k -1]
     *
     * @param mat
     * @param k
     * @return
     */

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] preparation = new int[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                for (int l = Math.max(0, i - k); l <= Math.min(mat.length -1, i + k); l++) {
                    preparation[i][j] = preparation[i][j] + mat[l][j];
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (j == 0) {
                    for (int l = 0; l <= Math.min(mat[i].length - 1, k); l++) {
                        ans[i][j] = ans[i][j] + preparation[i][l];
                    }
                } else {
                    ans[i][j] = ans[i][j - 1];
                    if (j - k - 1>= 0) {
                        ans[i][j] = ans[i][j] - preparation[i][j - k - 1];
                    }
                    if (j + k < mat[i].length) {
                        ans[i][j] = ans[i][j] + preparation[i][j + k];
                    }
                }
            }
        }
        return ans;
    }

    public static int[][] matrixBlockSum2(int[][] mat, int k) {
        int large = mat.length;
        int height = mat[0].length;
        int[][] preparation = new int[large][height];
        int[][] ans = new int[large][height];
        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0) {
                    for (int l = 0; l <= Math.min(large - 1, k); l++) {
                        preparation[i][j] = preparation[i][j] + mat[l][j];
                    }
                } else {
                    preparation[i][j] = preparation[i - 1][j];
                    if (i - k - 1 >= 0) {
                        preparation[i][j] = preparation[i][j] - mat[i - k - 1][j];
                    }
                    if (i + k < large) {
                        preparation[i][j] = preparation[i][j] + mat[i + k][j];
                    }
                }

            }
        }

        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0) {
                    for (int l = 0; l <= Math.min(height - 1, k); l++) {
                        ans[i][0] = ans[i][0] + preparation[i][l];
                    }
                } else {
                    ans[i][j] = ans[i][j - 1];
                    if (j - k - 1>= 0) {
                        ans[i][j] = ans[i][j] - preparation[i][j - k - 1];
                    }
                    if (j + k < height) {
                        ans[i][j] = ans[i][j] + preparation[i][j + k];
                    }
                }
            }
        }
        return ans;
    }

    /**
     * https://www.youtube.com/watch?v=v_wj_mOAlig
     * Fenwick Tree
     */
}
