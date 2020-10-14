package challenge.year2020.may;

import exercises.RedundantConnection;
import org.junit.Assert;
import org.junit.Test;

public class RedundantConnectionTest {

    @Test
    public void testCase1() {
        int[][] input = {{1,4},{3,4},{1,3},{1,2},{4,5}};
        int[] expected = {1,3};
        int[] actual = new RedundantConnection().findRedundantConnection(input);
        Assert.assertEquals(actual, expected);
    }
}
