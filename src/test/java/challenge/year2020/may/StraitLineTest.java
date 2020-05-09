package challenge.year2020.may;

import static junit.framework.TestCase.assertFalse;

import org.junit.Test;

public class StraitLineTest {
    @Test
    public void testCase1() {
        assertFalse(StraitLine.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    }
}
