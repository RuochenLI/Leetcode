package exercises;

import exercises.IPO;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 04/02/2017.
 */
public class IPOTest {

    @Test
    public void test1() {
        assertEquals(4, new IPO().findMaximizedCapital1(2, 0, new int[]{1,2,3}, new int[]{0,1,1}));
    }

    @Test
    public void test2() {
        assertEquals(3, new IPO().findMaximizedCapital1(1, 0, new int[]{1, 2, 3}, new int[]{2, 1, 0}));
    }
}
