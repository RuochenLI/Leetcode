package google.interviews;

import org.junit.Assert;
import org.junit.Test;


public class LongestPalindromeSubstringTest {
    @Test
    public void testHappyCase() {
        Assert.assertEquals("bab", new LongestPalindromeSubstring().longestPalindrome("babad"));
    }

    @Test
    public void testHappyCase1() {
        Assert.assertEquals("aaaa", new LongestPalindromeSubstring().longestPalindrome("aaaa"));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals("aaaa", new LongestPalindromeSubstring().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
