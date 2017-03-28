/**
 * Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
 * Find the maximum points you can get.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * Output:
 * 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 * <p>
 * The solution is the one on the internet but i implemented myself.
 * cache[l][r][k], the largest number we can get using lth to rth (inclusive) boxes with k same colored boxes as rth box appended at the end. Example,
 * cache[l][r][3] represents the solution for this setting: [b_l, ..., b_r, A,A,A] with b_r==A.
 * <p>
 * The transition function is to find the maximum among all b_i==b_r for i=l,...,r-1:
 * <p>
 * cache[l][r][k] = max(cache[l][r][k], cache[l][i][k+1] + cache[i+1][r-1][0])
 * <p>
 * Basically, if there is one i such that b_i==b_r, we partition the array into two: [b_l, ..., b_i, b_r, A, ..., A], and [b_{i+1}, ..., b_{r-1}]. The
 * solution for first one will be cache[l][i][k+1], and the second will be cache[i+1][r-1][0]. Otherwise, we just remove the last k+1 boxes (including b_r)
 * and search the best solution for lth to r-1th boxes.
 **/

/**
 * The solution is the one on the internet but i implemented myself.
 * cache[l][r][k], the largest number we can get using lth to rth (inclusive) boxes with k same colored boxes as rth box appended at the end. Example,
 * cache[l][r][3] represents the solution for this setting: [b_l, ..., b_r, A,A,A] with b_r==A.
 * <p>
 * The transition function is to find the maximum among all b_i==b_r for i=l,...,r-1:
 * <p>
 * cache[l][r][k] = max(cache[l][r][k], cache[l][i][k+1] + cache[i+1][r-1][0])
 * <p>
 * Basically, if there is one i such that b_i==b_r, we partition the array into two: [b_l, ..., b_i, b_r, A, ..., A], and [b_{i+1}, ..., b_{r-1}]. The
 * solution for first one will be cache[l][i][k+1], and the second will be cache[i+1][r-1][0]. Otherwise, we just remove the last k+1 boxes (including b_r)
 * and search the best solution for lth to r-1th boxes.
 **/

/**
 * Created by Ruochen on 28/03/2017.
 */


public class RemoveBoxes {
    private int[][][] cache;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        cache = new int[n][n][n];
        return findMaxValue(boxes, 0, n - 1, 0);
    }

    private int findMaxValue(int[] boxes, int head, int tail, int nbSameColorBox) {
        if (tail < head) {
            return 0;
        }

        if (cache[head][tail][nbSameColorBox] != 0) {
            return cache[head][tail][nbSameColorBox];
        }

        while (tail > head && boxes[tail - 1] == boxes[tail]) {
            tail--;
            nbSameColorBox++;
        }
        cache[head][tail][nbSameColorBox] = findMaxValue(boxes, head, tail - 1, 0) + (nbSameColorBox + 1) * (nbSameColorBox + 1);

        for (int i = head; i < tail; i++) {
            if (boxes[i] == boxes[tail]) {
                cache[head][tail][nbSameColorBox] = Math.max(cache[head][tail][nbSameColorBox],
                        findMaxValue(boxes, head, i, nbSameColorBox + 1) + findMaxValue(boxes, i + 1, tail - 1, 0));
            }
        }
        return cache[head][tail][nbSameColorBox];
    }
}
