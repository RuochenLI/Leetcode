package google.interviews;

import org.junit.Assert;
import org.junit.Test;

public class LastStoneWeightIITest {
    @Test
    public void testHappyCase() {
        Assert.assertEquals(1, new LastStoneWeightII().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
