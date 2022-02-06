package google.interviews;

import interviews.google.LastStoneWeightII;
import org.junit.Assert;
import org.junit.Test;

public class LastStoneWeightIITest {
    @Test
    public void testHappyCase0() {
        Assert.assertEquals(1, new LastStoneWeightII().lastStoneWeightII1(new int[]{2, 7, 4, 1, 8, 1}));
    }

    @Test
    public void testHappyCase1() {
        Assert.assertEquals(5, new LastStoneWeightII().lastStoneWeightII1(new int[]{31, 26, 33, 21, 40}));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(1, new LastStoneWeightII().lastStoneWeightII1(new int[]{14, 1, 7, 17, 8, 10}));
    }
}
