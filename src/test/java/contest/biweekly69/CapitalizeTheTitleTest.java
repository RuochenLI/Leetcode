package contest.biweekly69;

import org.junit.Assert;
import org.junit.Test;

public class CapitalizeTheTitleTest {
    @Test
    public void testCase1() {
        Assert.assertEquals("l hv", new CapitalizeTheTitle().capitalizeTitle("L hV"));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals("zw cl Pyr Uoc", new CapitalizeTheTitle().capitalizeTitle("ZW Cl pyR uoC"));
    }
}
