package google.interviews;

import interviews.google.MergeInterval;
import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalTest {
    @Test
    public void testHappyCase1(){
        Assert.assertEquals(new int[][]{{1,6},{8,10},{15,18}}, new MergeInterval().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }
}
