package challenge.year2020.may;

import org.junit.Assert;
import org.junit.Test;

public class SingleElementTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(new SingleElement().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}), 2);
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(new SingleElement().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}), 10);
    }
}
