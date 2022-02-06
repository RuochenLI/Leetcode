package exercises;

import com.google.common.collect.Lists;
import exercises.leetcode401_600.FindAllAnagrams_454;
import org.junit.Assert;
import org.junit.Test;

public class FindAllAnagramsTest {
    @Test
    public void testCase1() {
        Assert.assertEquals(Lists.newArrayList(0,6), new FindAllAnagrams_454().findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(Lists.newArrayList(0,1,2), new FindAllAnagrams_454().findAnagrams("abab", "ab"));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(Lists.newArrayList(1,2,3,5), new FindAllAnagrams_454().findAnagrams("abacbabc", "abc"));
    }
}
