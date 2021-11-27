package google.interviews;

import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals("aaabcbc", new DecodeString().decodeString("3[a]2[bc]"));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals("aaaaaaaaaa", new DecodeString().decodeString("10[a]"));
    }
}
