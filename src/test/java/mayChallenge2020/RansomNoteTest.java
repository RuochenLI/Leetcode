package mayChallenge2020;

import static org.junit.Assert.*;

import org.junit.Test;

public class RansomNoteTest {

    @Test
    public void testCase1() {
        assertFalse(RansomNote.canConstruct1("a", "b"));
        assertFalse(RansomNote.canConstruct2("a", "b"));
    }

    @Test
    public void testCase2() {
        assertFalse(RansomNote.canConstruct1("aa", "ab"));
        assertFalse(RansomNote.canConstruct2("aa", "ab"));

    }

    @Test
    public void testCase3() {
        assertTrue(RansomNote.canConstruct1("aa", "aab"));
        assertTrue(RansomNote.canConstruct2("aa", "aab"));

    }

    @Test
    public void testCase4() {
        assertTrue(RansomNote.canConstruct1("fffbfg", "effjfggbffjdgbjjhhdegh"));
        assertTrue(RansomNote.canConstruct2("fffbfg", "effjfggbffjdgbjjhhdegh"));

    }

    @Test
    public void tetCase5() {
        assertTrue(RansomNote.canConstruct1("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
        assertTrue(RansomNote.canConstruct2("bjaajgea",
                                            "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));

    }
}
