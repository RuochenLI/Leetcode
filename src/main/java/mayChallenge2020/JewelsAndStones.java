package mayChallenge2020;

import java.util.Set;
import java.util.stream.Collectors;

public class JewelsAndStones {
    /*
    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
     */
    public int numJewelsInStones(String J, String S) {

        Set<Character> characters = J.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        int result = 0;
        for (final char c : S.toCharArray()) {
            if (characters.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
