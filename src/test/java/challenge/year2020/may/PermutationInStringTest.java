package challenge.year2020.may;

import org.junit.Assert;
import org.junit.Test;

public class PermutationInStringTest {
    @Test
    public void testCase1() {
        Assert.assertTrue(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }
}
