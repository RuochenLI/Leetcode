package exercises;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 *
 * Created by Ruochen on 23/01/2017.
 */
public final class HammingDistance {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);

        // String binaryStr = Integer.toBinaryString(x ^ y);
        // int count = 0;
        // char[] chars = binaryStr.toCharArray();
        // for (char c : chars) {
        //     if (c == '1') {
        //         count++;
        //     }
        // }
        // return count;
    }
}
