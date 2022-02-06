package contest.biweekly66;

import context.biweekly66.CountCommonWordsWithOneOccurrence;
import org.junit.Assert;
import org.junit.Test;

public class CountCommonWordsWithOneOccurrenceTest {
    @Test
    public void testCase1() {
        Assert.assertEquals(2, new CountCommonWordsWithOneOccurrence().countWords(
                new String[]{"leetcode","is","amazing","as","is"},
                new String[]{"amazing","leetcode","is"}
        ));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(0, new CountCommonWordsWithOneOccurrence().countWords(
                new String[]{"b","bb","bbb"},
                new String[]{"a","aa","aaa"}
        ));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(1, new CountCommonWordsWithOneOccurrence().countWords(
                new String[]{"a","ab"},
                new String[]{"a","a","a","ab"}
        ));
    }
}
