package google.interviews;

import interviews.google.MinAbbreviation;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinAbbreviationTest {
    @Test
    public void testHappyCase1() {
        Assert.assertEquals("5", new MinAbbreviation().minAbbreviation("apple", new String[]{}) );
    }

    @Test
    public void testHappyCase2() {
        Assert.assertEquals("3l1", new MinAbbreviation().minAbbreviation("apple", new String[]{"blade"}) );
    }

    @Test
    public void testHappyCase3() {
        Assert.assertEquals("3le", new MinAbbreviation().minAbbreviation("apple", new String[]{"blade", "amber", "dpefg", "depfg", "deelg"}) );
    }

    @Test
    public void testHappyCase4() {
        Assert.assertEquals("5", new MinAbbreviation().minAbbreviation("apple", new String[]{"bladf"}) );
    }

    @Test
    public void testHappyCase5() {
        Assert.assertEquals("4o1", new MinAbbreviation().minAbbreviation("oygpoe", new String[]{"lfpbnp","ljvrvi","pyamye","hwqnqr","qpmxuj","jloova","owuxwh","msncbx","coksfz","kvatxd"}) );
    }

    @Test
    public void testHappyCase6() {
        SortedMap<Integer, Integer> test = Collections.emptySortedMap();
        Assert.assertEquals("4o1", new MinAbbreviation().minAbbreviation("tesjwh", new String[]{"izcobz","cnfwlq","ijtvdw","vxhrcb","ldvgyl","wgbusb","mborxt","lhcsmp","xohgmg"}) );
    }
}
