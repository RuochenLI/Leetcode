package interview;

import interviews.SwissQuote;
import org.junit.Assert;
import org.junit.Test;

public class SwissQuoteTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(2, new SwissQuote().solution("abccbd", new int[]{0, 1, 2, 3,4,5}));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(3, new SwissQuote().solution("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals(3, new SwissQuote().solution("aaa", new int[]{2, 1, 3}));
    }
}
