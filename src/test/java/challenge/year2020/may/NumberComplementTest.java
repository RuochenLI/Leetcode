package challenge.year2020.may;

import exercises.leetcode401_600.NumberComplement476;
import org.junit.Assert;
import org.junit.Test;

public class NumberComplementTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(2, NumberComplement476.findComplement(5));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(0, NumberComplement476.findComplement(1));
    }
}
