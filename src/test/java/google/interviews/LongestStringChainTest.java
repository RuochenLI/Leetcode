package google.interviews;

import interviews.google.LongestStringChain;
import org.junit.Assert;
import org.junit.Test;

public class LongestStringChainTest {
    @Test
    public void testHappyCase1() {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        Assert.assertEquals(4, new LongestStringChain().longestStrChain(words));
    }

    @Test
    public void testHappyCase2() {
        String[] words = {"abcd","dbqca"};
        Assert.assertEquals(1, new LongestStringChain().longestStrChain(words));
    }

    @Test
    public void testHappyCase3() {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Assert.assertEquals(5, new LongestStringChain().longestStrChain(words));
    }

    @Test
    public void testHappyCase4() {
        String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        Assert.assertEquals(7, new LongestStringChain().longestStrChain(words));
    }
}
