package challenge.year2020.may;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    @Test
    public void testCase1() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
    }
}
