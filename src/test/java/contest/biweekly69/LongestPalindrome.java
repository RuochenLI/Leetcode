package contest.biweekly69;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindrome {
    @Test
    public void testCase1() {
        Assert.assertEquals(22, new LongestPalindromeByConcatenatingTwoLettersWord().longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
    }
}
