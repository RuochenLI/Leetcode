package challenge.year2020.may;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pHash = new int[26];
        List<Integer> result = new ArrayList<>();
        for (final char c : p.toCharArray()) {
            pHash[c - 'a']++;
        }

        int pointer = 0;
        int slength = s.length();
        int plength = p.length();
        char[] sChars = s.toCharArray();
        while (pointer < slength) {
            if (pHash[sChars[pointer] - 'a'] >0) {
                int[] clonedHash = pHash.clone();
                int secondPointer = pointer;
                int count = 0;
                while (secondPointer < slength && clonedHash[sChars[secondPointer] - 'a'] > 0 && count < plength) {
                    clonedHash[sChars[secondPointer] - 'a']--;
                    secondPointer++;
                    count++;
                }
                if (count == plength) {
                    result.add(pointer);
                    while (secondPointer < slength && sChars[pointer] == sChars[secondPointer]) {
                        result.add(++pointer);
                        secondPointer++;
                    }
                    pointer = secondPointer - plength;
                }
            }
            pointer++;
        }
        return result;
    }
}
