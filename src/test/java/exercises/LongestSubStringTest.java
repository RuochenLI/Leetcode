package exercises;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStringTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(3, new LongestSubString().longestSubstring("aaabb", 3));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(5, new LongestSubString().longestSubstring("ababbc", 2));
    }
}
