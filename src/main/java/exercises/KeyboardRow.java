package exercises;

import java.util.*;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Created by Ruochen on 04/02/2017.
 */
public class KeyboardRow {

    Set<Character> chars1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    Set<Character> chars2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    Set<Character> chars3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
    Set[] letterSets = new Set[]{chars1, chars2, chars3};

    public String[] findWords(String[] words) {

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (valid(word)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);

    }

    private boolean valid(String word) {

        char[] chars = word.toCharArray();

        for (Set letterSet : letterSets) {
            boolean valid = true;
            for (char c : chars) {
                if (!letterSet.contains(Character.toLowerCase(c))) {
                    valid = false;
                    break;
                }
            }
            if (valid) return true;
        }

        return false;
    }
}
