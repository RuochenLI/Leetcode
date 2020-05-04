package mayChallenge2020;

import org.junit.Assert;
import org.junit.Test;

public class NumberComplementTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(2, NumberComplement.findComplement(5));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(0, NumberComplement.findComplement(1));
    }
}
