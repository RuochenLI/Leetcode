package challenge.year2020.may;

import org.junit.Assert;
import org.junit.Test;

public class RemoveKDigitsTest {
    @Test
    public void testCase1() {
        Assert.assertEquals(new RemoveKDigits().removeKdigits("1432219", 3), "1219");
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(new RemoveKDigits().removeKdigits("10200", 1), "200");
    }
}
