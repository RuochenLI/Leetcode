package challenge.year2020.may;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumCircularSubarrayTest {
    @Test
    public void testCase1() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{5,-3,5}), 10);
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{6, 9, -3}), 15);
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{-2, -3, -1}), -1);
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{-2}), -2);
    }

    @Test
    public void testCase5() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{3,1,3,2,6}), 15);
    }

    @Test
    public void testCase6() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{-2,4,-5,4,-5,9,4}), 15);
    }

    @Test
    public void testCase7() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{-1,3,-3,9,-6,8,-5,-5,-6,10}), 20);
    }

    @Test
    public void testCase8() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{1,-2,3,-2}), 3);
    }

    @Test
    public void testCase9() {
        Assert.assertEquals(new MaxSumCircularSubarray().maxSubarraySumCircular(new int[]{0,5,8,-9,9,-7,3,-2}), 16);
    }
}
