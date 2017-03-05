/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * Created by liruochen on 3/5/17.
 */
public class NumberOfOneBits {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
