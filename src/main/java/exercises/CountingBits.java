package exercises;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].
 *
 * Created by liruochen on 3/5/17.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    /*better solution
    public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}
     */
}
