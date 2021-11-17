package exercises;

import challenge.year2021.UniquePaths;
import org.junit.Assert;
import org.junit.Test;

public class UniquePathTest {

    @Test
    public void testHappyCase() {
        Assert.assertEquals(3, new UniquePaths().uniquePaths1(3, 2));
    }
}
