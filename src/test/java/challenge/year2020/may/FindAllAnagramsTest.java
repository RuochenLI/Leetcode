package challenge.year2020.may;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

public class FindAllAnagramsTest {
    @Test
    public void testCase1() {
        Assert.assertEquals(Lists.newArrayList(0,6), new FindAllAnagrams().findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(Lists.newArrayList(0,1,2), new FindAllAnagrams().findAnagrams("abab", "ab"));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(Lists.newArrayList(1,2,3,5), new FindAllAnagrams().findAnagrams("abacbabc", "abc"));
    }
}
