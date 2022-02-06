package contest.biweekly66;

import context.biweekly66.MinCost;
import org.junit.Assert;
import org.junit.Test;

public class MinCostTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(18, new MinCost().minCost(
                new int[]{1, 0},
                new int[]{2, 3},
                new int[]{5, 4, 3},
                new int[]{8, 2, 6, 7}
        ));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(0, new MinCost().minCost(
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{5, 4, 3},
                new int[]{8, 2, 6, 7}
        ));
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals(8, new MinCost().minCost(
                new int[]{5, 5},
                new int[]{5, 2},
                new int[]{7,1,3,3,5,3,22,10,23},
                new int[]{5,5,6,2,0,16}
        ));
    }
}
