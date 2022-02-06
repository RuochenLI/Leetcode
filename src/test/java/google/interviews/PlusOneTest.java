package google.interviews;

import interviews.google.PlusOne;
import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(new int[]{1, 2, 4}, new PlusOne().plusOne(new int[]{1,2,3}));
    }
}
