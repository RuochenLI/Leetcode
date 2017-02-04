import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class MatchsticksToSquareTest {

    @Test
    public void testCase1() {
        assertTrue(new MatchsticksToSquare().makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }

    @Test
    public void testCase2() {
        assertFalse(new MatchsticksToSquare().makesquare(new int[]{8,16,24,32,40,48,56,64,72,80,88,96,104,112,60}));
    }


    @Test
    public void testCase3() {
        assertFalse(new MatchsticksToSquare().makesquare(new int[]{12,12,12,16,20,24,28,32,36,40,44,48,52,56,60}));
    }
}
