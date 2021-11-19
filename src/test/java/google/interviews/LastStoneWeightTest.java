package google.interviews;

import org.junit.Assert;
import org.junit.Test;

public class LastStoneWeightTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
