package exercises.leetcode401_600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams_454 {

    //slicing window solution
    public List<Integer> findAnagrams(String s, String p) {
        int[] expectedHash = new int[26];
        int[] actualHash = new int[26];
        List<Integer> result = new ArrayList<>();
        for (final char c : p.toCharArray()) {
            expectedHash[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int pLength = p.length();
        int sLength = s.length();
        while (right < sLength) {
            if (right - left + 1< pLength) {
                actualHash[s.charAt(right++) - 'a']++;
            } else {
                actualHash[s.charAt(right++) - 'a']++;
                if (Arrays.equals(actualHash, expectedHash)) result.add(left);
                actualHash[s.charAt(left++) - 'a']--;
            }
        }

        return result;
    }

    public List<Integer> findAnagrams1(String s, String p) {
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
