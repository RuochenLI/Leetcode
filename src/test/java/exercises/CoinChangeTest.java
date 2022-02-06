package exercises;

import exercises.leetcode201_400.CoinChange_322;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void testHappyCase1() {
        new CoinChange_322().coinChange(new int[]{2, 5, 10, 1}, 27);
    }
}
