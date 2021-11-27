package exercises;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(2, new SearchInsert().searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(1, new SearchInsert().searchInsert(new int[]{1,3}, 2));
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals(2, new SearchInsert().searchInsert(new int[]{1,3, 5}, 4));
    }

    @Test
    public void testHappyCase4() {
        Assert.assertEquals(1, new SearchInsert().searchInsert(new int[]{1,3,5,6}, 2));
    }
}
