package challenge.year2020.may;

import java.util.Arrays;

/**
 *  Permutation in String
 * Solution
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] expectedHash = new int[26];
        int[] actualHash = new int[26];
        for (final char c : s1.toCharArray()) {
            expectedHash[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();
        while (right < s2Length) {
            if (right - left + 1< s1Length) {
                actualHash[s2.charAt(right) - 'a']++;
                right++;
            } else {
                actualHash[s2.charAt(right++) - 'a']++;
                if (Arrays.equals(actualHash, expectedHash)) return true;
                actualHash[s2.charAt(left++) - 'a']--;
            }
        }

        return false;
    }
}
