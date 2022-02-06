package contest.biweekly66;

import context.biweekly66.MinimumBuckets;
import org.junit.Assert;
import org.junit.Test;

public class MinimumBucketsTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(2, new MinimumBuckets().minimumBuckets("H..H"));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(1, new MinimumBuckets().minimumBuckets(".H.H."));
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals(-1, new MinimumBuckets().minimumBuckets("H"));
    }

    @Test
    public void testHappyCase4() {
        Assert.assertEquals(-1, new MinimumBuckets().minimumBuckets(".HHH."));
    }

    @Test
    public void testHappyCase5() {
        Assert.assertEquals(0, new MinimumBuckets().minimumBuckets("."));
    }

    @Test
    public void testHappyCase6() {
        Assert.assertEquals(3, new MinimumBuckets().minimumBuckets(".HH.H.H.H.."));
    }

    @Test
    public void testHappyCase7() {
        Assert.assertEquals(2, new MinimumBuckets().minimumBuckets("......HH....."));
    }
}
