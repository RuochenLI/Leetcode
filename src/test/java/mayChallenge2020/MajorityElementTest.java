package mayChallenge2020;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void testcase1() {
        assertEquals(MajorityElement.majorityElement2(new int[]{3, 2, 3}), 3);
    }

    @Test
    public void testcase2() {
        assertEquals(MajorityElement.majorityElement2(new int[]{2,2,1,1,1,1,1,1,1,2,2}), 1);
    }

    @Test
    public void testcase3() {
        assertEquals(MajorityElement.majorityElement2(new int[]{1}), 1);
    }
}
