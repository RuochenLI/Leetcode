package google.interviews;

import interviews.google.CountSquareSubmatricesWithAllOnes;
import org.junit.Assert;
import org.junit.Test;

public class CountSquareSubmatricesWithAllOnesTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals(15, new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals(8, new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}}));
    }
}
