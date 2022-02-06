package google.interviews;


import interviews.google.MatricBlockSum;
import junit.framework.Assert;
import org.junit.Test;

public class MatricBlockSumTest {
    @Test
    public void testCase1() {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        int[][] expected = {{12,21,16},{27,45,33},{24,39,28}};
        Assert.assertEquals(MatricBlockSum.matrixBlockSum2(mat, k), expected);
    }
}
