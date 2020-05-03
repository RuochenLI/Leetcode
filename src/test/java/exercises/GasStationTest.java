package exercises;

import exercises.GasStation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ruochen on 29/01/2017.
 */
public class GasStationTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(-1, new GasStation().canCompleteCircuit(new int[]{4}, new int[]{5}));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(0, new GasStation().canCompleteCircuit(new int[]{5}, new int[]{4}));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(1, new GasStation().canCompleteCircuit(new int[]{2,3,1}, new int[]{3,1,2}));
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(1, new GasStation().canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1}));
    }
}
