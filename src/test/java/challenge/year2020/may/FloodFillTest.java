package challenge.year2020.may;

import org.junit.Test;

public class FloodFillTest {

    @Test
    public void testcase1() {
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2);
    }
}
