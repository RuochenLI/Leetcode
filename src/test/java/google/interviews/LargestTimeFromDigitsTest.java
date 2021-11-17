package google.interviews;

import org.junit.Assert;
import org.junit.Test;

public class LargestTimeFromDigitsTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(new LargestTimeFromDigits().largestTimeFromDigits(new int[] {2, 0, 6, 6}), "06:26");
    }
}
